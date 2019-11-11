package ngo.ngoapp.dbseeder;


import ngo.ngoapp.model.Address;
import ngo.ngoapp.model.Admin;
import ngo.ngoapp.model.NGO;
import ngo.ngoapp.model.User;
import ngo.ngoapp.mongorepository.AdminRepository;
import ngo.ngoapp.mongorepository.NGORepository;
import ngo.ngoapp.mongorepository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private AdminRepository adminRepository;
    private NGORepository ngoRepository;
    private UserRepository userRepository;

    public DbSeeder(AdminRepository adminRepository, NGORepository ngoRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.ngoRepository = ngoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Admin first = new Admin(
                "admin_a",
                "admin_a@daiict.ac.in",
                "admin",
                "7874353439"
        );

        Admin second = new Admin(
                "admin_b",
                "admin_b@daiict.ac.in",
                "admin",
                "7874333435"
        );

        Admin third = new Admin(
                "admin_c",
                "admin_c@daiict.ac.in",
                "admin",
                "9897969594"
        );

        // Delete All AdminData
        this.adminRepository.deleteAll();

        // Insert New Admin Data
        List<Admin> admins = Arrays.asList(first,second,third);
        this.adminRepository.saveAll(admins);

        NGO first_ngo = new NGO(
                "Child Care",
                "7359324923",
                "info@childcare.com",
                "123456",
                false,
                new Address("22-24,Kalupur","Near Ranibag",382004,"Ahmedabad","india"),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        this.ngoRepository.deleteAll();
        this.ngoRepository.save(first_ngo);

        User first_user = new User(
                "Maya",
                "9824752829",
                "maya1996@gmail.com",
                "123456",
                new Date(1996, 1, 1)
        );

        User second_user = new User(
                "Raj",
                "7778899552",
                "raj1996@gmail.com",
                "123456",
                new Date(1996, 12, 1)
        );

        this.userRepository.deleteAll();

        List<User> users = Arrays.asList(first_user,second_user);
        this.userRepository.saveAll(users);

    }
}
