package ngo.ngoapp.model;

public class Volunteer {
    private String user_id;
    private String registered_on;

    public Volunteer(String user_id, String registered_on) {
        this.user_id = user_id;
        this.registered_on = registered_on;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRegistered_on() {
        return registered_on;
    }

    public void setRegistered_on(String registered_on) {
        this.registered_on = registered_on;
    }
}
