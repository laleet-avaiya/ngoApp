package ngo.ngoapp.model;

import java.util.Date;

public class Post {
    private String title;
    private String description;
    private Date posted_on;


    public Post(String title, String description) {
        this.title = title;
        this.description = description;
        this.posted_on = new Date();
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

    public Date getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(Date posted_on) {
        this.posted_on = posted_on;
    }



}
