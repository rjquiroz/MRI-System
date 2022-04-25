package mriSystem;

public class InsuranceCompany {
    private String name;
    private String phone;

    private String fax;
    private Address address;
    private String contactName;
    private String contactMidName;
    private String contactLastName;
    private String contactPhone;
    private String contactFax;
    private String altPhone;
    private String contactEmail;

    public InsuranceCompany(){

    }

    public InsuranceCompany(String name, String phone, String fax,Address address, String contactName, String contactMidName, String contactLastName, String contactPhone, String contactFax, String altPhone, String contactEmail){
         this.name= name;
         this.phone= phone;
         this.fax = fax;
         this.address= address;
         this.contactName= contactName;
         this.contactMidName= contactMidName;
         this.contactLastName= contactLastName;
         this.contactPhone= contactPhone;
         this.contactFax= contactFax;
         this.altPhone= altPhone;
         this.contactEmail= contactEmail;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public Address getAddress() {
        return address;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactMidName() {
        return contactMidName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactFax() {
        return contactFax;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", address=" + address +
                ", contactName='" + contactName + '\'' +
                ", contactMidName='" + contactMidName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactFax='" + contactFax + '\'' +
                ", altPhone='" + altPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}