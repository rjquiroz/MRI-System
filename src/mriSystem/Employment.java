package mriSystem;

public class Employment{
    private String companyName;
    private Address address;
    private String contactFName;
    private String contactLName;
    private String email;
    private String phone;
    private String fax;

    public Employment(){

    }

    public Employment(String companyName, Address address, String contactFName,  String contactLName, String email, String phone, String fax){
        this.companyName = companyName;
        this.address = address;
        this.contactFName = contactFName;
        this.contactLName = contactLName;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
    }

    public String toString(){
        return "\nEmployer Information: \n\nCompany Name: " + companyName + "\nPhone: " + phone + "\nFax: " + fax + "\nContact First Name: " + contactFName + "\nContact Last Name: " + contactLName + "\nContact Email: " + email + address.toString();
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContactFName(String contactFName) {
        this.contactFName = contactFName;
    }

    public void setContactLName(String contactLName) {
        this.contactLName = contactLName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Address getAddress() {
        return address;
    }

    public String getContactFName() {
        return contactFName;
    }

    public String getContactLName() {
        return contactLName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }
}
