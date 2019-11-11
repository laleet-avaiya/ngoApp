package ngo.ngoapp.controller;

import ngo.ngoapp.model.NGO;
import ngo.ngoapp.mongorepository.NGORepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ngo")
public class NGOController {

    private NGORepository ngoRepository;

    public NGOController(NGORepository ngoRepository) {
        this.ngoRepository = ngoRepository;
    }

    @PutMapping()
    public NGO insert(@RequestBody NGO ngo){
        this.ngoRepository.insert(ngo);
        return ngo;
    }

    @PostMapping()
    public NGO update(@RequestBody NGO ngo){
        this.ngoRepository.save(ngo);
        return ngo;
    }

    @GetMapping("/all")
    public List<NGO> getAll(){
        List<NGO> ngos= this.ngoRepository.findAll();
        return ngos;
    }

    @PostMapping("/approve")
    public NGO approve(@RequestBody NGO ngo)
    {
        System.out.println(ngo.getEmail());

        NGO newngo = this.ngoRepository.findByEmail(ngo.getEmail());
        newngo.setStatus(ngo.getStatus());

        this.ngoRepository.save(newngo);
        return newngo;
    }

    @PostMapping("/login")
    public NGO login(@RequestBody NGO ngo){

        System.out.println(ngo.getEmail());
        NGO authorities = this.ngoRepository.findByEmail(ngo.getEmail());

        if(authorities==null)
        {
            System.out.println("Admin Not Found");
            return null;
        }

        if(authorities.getPassword().equals(ngo.getPassword())) {
            if(authorities.getStatus())
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


    // Add Post

//    @PutMapping("/post")
//    public NGO insert(@RequestParam String email,@RequestParam String title,@RequestParam String description){
//        NGO ngo = this.ngoRepository.findByEmail(email);
//
//        List<Post> posts = ngo.getPosts();
//        posts.add(new Post(title,description));
//
//        this.ngoRepository.save(ngo);
//        return ngo;
//    }


}