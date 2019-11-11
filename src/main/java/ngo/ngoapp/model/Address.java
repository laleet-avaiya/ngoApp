package ngo.ngoapp.model;

public class Address {
    private String line1;
    private String line2;
    private int pincode;
    private String city;
    private String country;

    public Address(){}

    public Address(String line1, String line2, int pincode, String city, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.pincode = pincode;
        this.city = city;
        this.country = country;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
