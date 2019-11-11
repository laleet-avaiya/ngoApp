package ngo.ngoapp.model;

import java.util.Date;

public class Donation {
    private String user_id;
    private String ngo_id;
    private float amount;
    private Date donate_on;
    private String payment_mode;

    public Donation(String user_id, String ngo_id, float amount, Date donate_on, String payment_mode) {
        this.user_id = user_id;
        this.ngo_id = ngo_id;
        this.amount = amount;
        this.donate_on = donate_on;
        this.payment_mode = payment_mode;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNgo_id() {
        return ngo_id;
    }

    public void setNgo_id(String ngo_id) {
        this.ngo_id = ngo_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDonate_on() {
        return donate_on;
    }

    public void setDonate_on(Date donate_on) {
        this.donate_on = donate_on;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }
}
