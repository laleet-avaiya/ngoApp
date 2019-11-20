package ngo.ngoapp.controller;

import ngo.ngoapp.model.Admin;
import ngo.ngoapp.model.NGO;
import ngo.ngoapp.mongorepository.AdminRepository;

import ngo.ngoapp.mongorepository.NGORepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

//@RestController
@Controller
@SessionAttributes({"name","email"})
public class AdminController {

    private AdminRepository adminRepository;
    private NGORepository ngoRepository;

    public AdminController(AdminRepository adminRepository, NGORepository ngoRepository) {
        this.adminRepository = adminRepository;
        this.ngoRepository = ngoRepository;
    }



    @PutMapping("/admin")
    @ResponseBody
    public Admin insert(@RequestBody Admin admin){
        this.adminRepository.insert(admin);
        return admin;
    }

    @PostMapping("/admin")
    @ResponseBody
    public Admin update(@RequestBody Admin admin){
        this.adminRepository.save(admin);
        return admin;
    }

    @GetMapping("/admin/all")
    @ResponseBody
    public List<Admin> getAll(){
        List<Admin> admins= this.adminRepository.findAll();
        return admins;
    }


//    @ResponseBody
    @RequestMapping("/admin/login")
    public String loginPage(ModelMap model){
        List<NGO> ngos = this.ngoRepository.findAll();
        model.put("ngos",ngos);
        System.out.println(ngos.size());
        if(model.containsKey("name"))
            return "redirect:home";
        return "login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, ModelMap model){
        Admin authorities = this.adminRepository.findByEmail(email);
        List<NGO> ngos = this.ngoRepository.findAll();
        if(authorities==null)
        {
            model.put("errorMsg", "User Not Found!!!");
            return "login";
        }
        if(authorities.getPassword().equals(password))
        {
            model.put("name", authorities.getName());
            model.put("email", authorities.getEmail());
            model.put("ngos",ngos);
            System.out.println(ngos.size());
            return "redirect:home";
        }
        else {
            model.put("errorMsg", "Invalid Credentials");
            return "login";
        }
    }

    //	DashBoard
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String HomePage(ModelMap model){
        List<NGO> ngos = this.ngoRepository.findAll();
        model.put("ngos",ngos);
        if(model.containsKey("name")==false)
            return "redirect:login";
        return "home";
    }


    //	Logout
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String Logout(ModelMap model, WebRequest request){
        model.clear();
        request.removeAttribute("name", WebRequest.SCOPE_SESSION);
        request.removeAttribute("email", WebRequest.SCOPE_SESSION);
        return "redirect:login";
    }

    @PostMapping("/admin/approve")
    public String approve(@RequestParam MultiValueMap body)
    {
        String email = (String) body .getFirst("email");

        NGO newngo = this.ngoRepository.findByEmail(email);
        newngo.setStatus(!newngo.isStatus());

        this.ngoRepository.save(newngo);
        return "redirect:home";
    }
}
