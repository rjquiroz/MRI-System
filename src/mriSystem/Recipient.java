package mriSystem;

import java.time.LocalDate;

public class Recipient {
    private String fName;
    private String ssn;
    private String phone;
    private String gender;
    private String Mname;
    private LocalDate birthDate;
    private String marital;
    private String lname;
    private String maidenName;
    private String birthPlace;
    private String state;
    private Address currentAddress;
    private FuneralHome funHome;
    private Employment employer;


    public Recipient(String recipfName, String reciplName, String recipmName, String gender, String birthDay, String birthPlace, String maritalStatus, String maidenName, String SSN, String phone, String state, String address, String funeralHome, String recipEmployer){

    }

    public Recipient(String fName, String ssn, String phone, String gender, String Mname, LocalDate birthDate, String marital, String lname, String maidenName, String birthPlace, String state, Address currentAddress, FuneralHome funHome, Employment employer){
        this.fName = fName;
        this.ssn = ssn;
        this.phone = phone;
        this.gender = gender;
        this.Mname = Mname;
        this.birthDate = birthDate;
        this.marital = marital;
        this.lname = lname;
        this.maidenName = maidenName;
        this.birthPlace = birthPlace;
        this.state = state;
        this.currentAddress =currentAddress;
        this.funHome = funHome;
        this.employer = employer;
    }


    @Override
    public String toString(){
        return "Recipient Information: \n\nFirst Name: " + fName + "\nSocial Security Number: " + ssn + "\nPhone Number: " + phone + "\nGender: " + gender + "\nMiddle Name: " + Mname + "\nBirth Date: " + birthDate + "\nMarital Status: " + marital + "\nLast Name: " + lname + "\nMaiden Name: " + maidenName + "\nPlace of Birth: " + birthPlace + "\nState: " + state + currentAddress.toString() + funHome.toString() + employer.toString();
    }


}
