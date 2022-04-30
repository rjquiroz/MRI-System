package mriSystem;

public class Address {
    private String street;
    private String city;
    private String state;
    private String country; 
    private String zipcode;

    public Address(){

    }

    public Address(String street, String city, String state, String country, String zipcode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String toString(){
        return "\n\nAddress: \n\nStreet Address: " + street + "\nCity: " +  city + "\nState: " + state + "\nCountry: " + country + "\nZipCode: " + zipcode + "\n";
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
