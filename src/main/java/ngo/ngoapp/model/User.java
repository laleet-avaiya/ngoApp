package ngo.ngoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String date_of_birth;


}
