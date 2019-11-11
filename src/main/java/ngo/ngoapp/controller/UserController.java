package ngo.ngoapp.controller;


import ngo.ngoapp.model.User;
import ngo.ngoapp.mongorepository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PutMapping()
    public User insert(@RequestBody User user){
        this.userRepository.insert(user);
        return user;
    }

    @PostMapping()
    public User update(@RequestBody User user){

        User old_user = this.userRepository.findByEmail(user.getEmail());
        user.setPassword(old_user.getPassword());

        this.userRepository.save(user);
        return user;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        List<User> users= this.userRepository.findAll();
        return users;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){

        System.out.println(user.getEmail());
        User authorities = this.userRepository.findByEmail(user.getEmail());

        if(authorities==null)
        {
            System.out.println("Admin Not Found");
            return null;
        }

        if(authorities.getPassword().equals(user.getPassword()))
            return authorities;
        else{
            System.out.println("Incorrect Password");
            return null;
        }
    }

}
