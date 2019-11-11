package ngo.ngoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "event")
public class Event {
    @Id
    private String id;

    private String ngo_id;
    private String title;
    private String description;
    private Date posted_on;


    public Event(String ngo_id, String title, String description) {
        this.ngo_id = ngo_id;
        this.title = title;
        this.description = description;
        this.posted_on = new Date();
    }




    public String getNgo_id() {
        return ngo_id;
    }

    public void setNgo_id(String ngo_id) {
        this.ngo_id = ngo_id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEvent_on() {
        return posted_on;
    }

    public void setEvent_on(Date posted_on) {
        this.posted_on = posted_on;
    }





}
