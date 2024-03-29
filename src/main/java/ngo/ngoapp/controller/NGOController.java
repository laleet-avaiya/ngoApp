package ngo.ngoapp.controller;

import ngo.ngoapp.model.Event;
import ngo.ngoapp.model.NGO;
import ngo.ngoapp.model.Post;
import ngo.ngoapp.mongorepository.EventRepository;
import ngo.ngoapp.mongorepository.NGORepository;
import ngo.ngoapp.mongorepository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;


//@RestController
@Controller
@RequestMapping("/ngo")
public class NGOController {

    private NGORepository ngoRepository;
    private EventRepository eventRepository;
    private PostRepository postRepository;

    public NGOController(NGORepository ngoRepository, EventRepository eventRepository, PostRepository postRepository) {
        this.ngoRepository = ngoRepository;
        this.eventRepository = eventRepository;
        this.postRepository = postRepository;
    }

    @PutMapping()
    public NGO insert(@RequestBody NGO ngo){
        this.ngoRepository.insert(ngo);
        return ngo;
    }

    @PostMapping()
    @ResponseBody
    public NGO update(@RequestBody NGO ngo){
        this.ngoRepository.save(ngo);
        return ngo;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<NGO> getAll(){
        List<NGO> ngos= this.ngoRepository.findAll();
        return ngos;
    }

    // NGO by ngo id
    @GetMapping("/ngo_by_id")
    @ResponseBody
    public NGO getNgoById(@RequestParam String ngo_id){
        List<NGO> ngos = this.ngoRepository.findAll();
        ngos.removeIf(ngo -> !ngo.getId().equals(ngo_id));
        return ngos.get(0);
    }

    @PostMapping("/approve")
    public String approve(@RequestParam MultiValueMap body)
    {
        String email = (String) body .getFirst("email");

        NGO newngo = this.ngoRepository.findByEmail(email);
        newngo.setStatus(!newngo.isStatus());

        this.ngoRepository.save(newngo);
        return "redirect:home";
    }

    @PostMapping("/login")
    public NGO login(@RequestBody NGO ngo){


        NGO authorities = this.ngoRepository.findByEmail(ngo.getEmail());

        if(authorities==null)
        {
            System.out.println("Admin Not Found");
            return null;
        }

        if(authorities.getPassword().equals(ngo.getPassword())) {
            if(authorities.isStatus())
            {
                return authorities;
            }
            else{
                System.out.println("Approval Pending!!!");
                return null;
            }
        }
        else{
            System.out.println("Incorrect Password");
            return null;
        }
    }


    /*--------------------------------------------------------------------*/
    /*---------------------------------post-------------------------------*/
    /*--------------------------------------------------------------------*/

    // Add Post
    @PutMapping("/post")
    @ResponseBody
    public Post insert(@RequestParam String ngo_id,@RequestParam String title,@RequestParam String description){
        Post post = new Post(ngo_id,title,description);
        this.postRepository.save(post);
        return post;
    }

    // get list of post for given NGO id
    @GetMapping("/post")
    @ResponseBody
    public List<Post> getPosts(@RequestParam String ngo_id){
        List<Post> posts = this.postRepository.findAll();
        posts.removeIf(post -> !post.getNgo_id().equals(ngo_id));
        return posts;
    }


    /*--------------------------------------------------------------------*/
    /*---------------------------------event-------------------------------*/
    /*--------------------------------------------------------------------*/

    // Add Event
    @PutMapping("/event")
    @ResponseBody
    public Event insertEvent(@RequestParam String ngo_id,@RequestParam String title,@RequestParam String description){
        Event event = new Event(ngo_id,title,description);
        this.eventRepository.save(event);
        return event;
    }

    // get list of event for given NGO id
    @GetMapping("/events_by_ngo_id")
    @ResponseBody
    public List<Event> getEvents(@RequestParam String ngo_id){
        List<Event> events = this.eventRepository.findAll();
        events.removeIf(event -> !event.getNgo_id().equals(ngo_id));
        return events;
    }
}