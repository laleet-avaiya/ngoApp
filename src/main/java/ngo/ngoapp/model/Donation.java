package ngo.ngoapp.model;

import java.util.Date;

public class Donation {
    private String user_id;
    private float amount;
    private Date donate_on;
    private String payment_mode;

    public Donation(String user_id, float amount, Date donate_on) {
        this.user_id = user_id;
        this.amount = amount;
        this.donate_on = donate_on;
    }

    public String getUser_id() {
        return user_id;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDonate_on() {
        return donate_on;
    }
}
