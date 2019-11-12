package ngo.ngoapp.controller;


import ngo.ngoapp.model.Donation;
import ngo.ngoapp.model.User;
import ngo.ngoapp.model.Volunteer;
import ngo.ngoapp.mongorepository.DonationRepository;
import ngo.ngoapp.mongorepository.UserRepository;
import ngo.ngoapp.mongorepository.VolunteerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserRepository userRepository;
    private VolunteerRepository volunteerRepository;
    private DonationRepository donationRepository;

    public UserController(UserRepository userRepository, VolunteerRepository volunteerRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.volunteerRepository = volunteerRepository;
        this.donationRepository = donationRepository;
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


    // Add Event
    @PutMapping("/volunteer")
    public Volunteer insertEvent(@RequestParam String user_id, @RequestParam String event_id){
        Volunteer volunteer = new Volunteer(user_id,event_id);
        this.volunteerRepository.save(volunteer);
        return volunteer;
    }

    // get list of volunteer_by_user_id
    @GetMapping("/volunteer_by_user_id")
    public List<Volunteer> getVolunteersById(@RequestParam String user_id){
        List<Volunteer> volunteers = this.volunteerRepository.findAll();
        volunteers.removeIf(volunteer -> !volunteer.getUser_id().equals(user_id));
        return volunteers;
    }

    // get list of volunteer_by_event_id
    @GetMapping("/volunteer_by_event_id")
    public List<Volunteer> getVolunteersByEventId(@RequestParam String event_id){
        List<Volunteer> volunteers = this.volunteerRepository.findAll();

        volunteers.removeIf(volunteer -> !volunteer.getEvent_id().equals(event_id));

        return volunteers;
    }


    /*------------------------Donate To NGO-------------------------------*/

    @PutMapping("/donation")
    public Donation InsertDonation(@RequestParam String ngo_id,@RequestParam String user_id,@RequestParam float amount){
        Donation donation = new Donation(user_id,ngo_id,amount);
        this.donationRepository.save(donation);
        return donation;
    }


    // get list of volunteer_by_user_id
    @GetMapping("/donations_by_user_id")
    public List<Donation> getDonationByUserId(@RequestParam String user_id){
        List<Donation> donations = this.donationRepository.findAll();
        donations.removeIf(donation -> !donation.getUser_id().equals(user_id));
        return donations;
    }

    // get list of volunteer_by_ngo_id
    @GetMapping("/donations_by_ngo_id")
    public List<Donation> getDonationsByNgoId(@RequestParam String ngo_id){
        List<Donation> donations = this.donationRepository.findAll();
        donations.removeIf(donation -> !donation.getNgo_id().equals(ngo_id));
        return donations;
    }

}
