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
    private Date date_of_birth;

    public User(String name, String phone, String email, String password, String date_of_birth) throws Exception{
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;

        String sDate1="31/12/1998";
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date_of_birth);
        this.date_of_birth = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}