package ngo.ngoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NgoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgoappApplication.class, args);
        System.out.println("Connection Start");
    }

}
