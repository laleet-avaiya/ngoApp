package ngo.ngoapp.controller;

import ngomediator.ngomediatorapi.model.Admin;
import ngomediator.ngomediatorapi.mongorepository.AdminRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/admin")
@SessionAttributes({"name","email"})
public class AdminController {

    private AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PutMapping()
    @ResponseBody
    public Admin insert(@RequestBody Admin admin){
        this.adminRepository.insert(admin);
        return admin;
    }

    @PostMapping()
    @ResponseBody
    public Admin update(@RequestBody Admin admin){
        this.adminRepository.save(admin);
        return admin;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Admin> getAll(){
        List<Admin> admins= this.adminRepository.findAll();
        return admins;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model){
        if(model.containsKey("name"))
            return "redirect:home";
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, ModelMap model){
        Admin authorities = this.adminRepository.findByEmail(email);
        System.out.println(email + " " + password);
        if(authorities==null)
        {
            model.put("errorMsg", "User Not Found!!!");
            return "login";
        }
        if(authorities.getPassword().equals(password))
        {
            model.put("name", authorities.getName());
            model.put("email", authorities.getEmail());
            return "redirect:home";
        }
        else {
            model.put("errorMsg", "Invalid Credentials");
            return "login";
        }
    }

    //	DashBoard
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String HomePage(ModelMap model){
        if(model.containsKey("name")==false)
            return "redirect:login";
        return "home";
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public String EventPage(ModelMap model){

        return "List of Events";
    }

    //	Logout
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout(ModelMap model, WebRequest request){
        model.clear();
        request.removeAttribute("name", WebRequest.SCOPE_SESSION);
        request.removeAttribute("email", WebRequest.SCOPE_SESSION);
        return "redirect:login";
    }
}
