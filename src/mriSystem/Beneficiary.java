package mriSystem;

public class Beneficiary {
    private String fName;
    private String lName;
    private String relationship;
    private String zipcode;

    public Beneficiary(){

    }

    public Beneficiary(String fName, String lName, String relationship, String zipcode){
        this.fName = fName;
        this.lName = lName;
        this.relationship = relationship;
        this.zipcode = zipcode;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getZipcode() {
        return zipcode;
    }
}
