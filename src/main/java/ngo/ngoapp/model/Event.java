package ngo.ngoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "event")
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private Date event_on;
//    private List<Volunteer> volunteers;

    public Event(String title, String description, Date event_on, List<Volunteer> volunteers) {
        this.title = title;
        this.description = description;
        this.event_on = event_on;
//        this.volunteers = volunteers;
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
        return event_on;
    }

    public void setEvent_on(Date event_on) {
        this.event_on = event_on;
    }

//    public List<Volunteer> getVolunteers() {
//        return volunteers;
//    }
//
//    public void setVolunteers(List<Volunteer> volunteers) {
//        this.volunteers = volunteers;
//    }

}
