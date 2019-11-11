package ngo.ngoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "volunteer")
public class Volunteer {
    @Id
    private String id;
    private String user_id;
    private String event_id;
    private Date registered_on;


    public Volunteer(String user_id, String event_id) {
        this.user_id = user_id;
        this.event_id = event_id;
        this.registered_on = new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public Date getRegistered_on() {
        return registered_on;
    }

    public void setRegistered_on(Date registered_on) {
        this.registered_on = registered_on;
    }
}
