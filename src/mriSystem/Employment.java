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


}
