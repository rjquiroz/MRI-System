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
    private Address currentAddress = new Address();
    private FuneralHome funHome = new FuneralHome();
    private Employment employer = new Employment();

    public Recipient(String recipfName, String reciplName, String recipmName, String gender, LocalDate birthDay, String birthPlace, String maritalStatus, String maidenName, String SSN, String phone, String state, String address, String funeralHome, String recipEmployer){
        fName = recipfName;
        lname = reciplName;
        Mname = recipmName;
        this.gender = gender;
        this.birthDate = birthDay;
        this.birthPlace = birthPlace;
        marital = maritalStatus;
        this.maidenName = maidenName;
        this.ssn = SSN;
        this.phone = phone;
        currentAddress.setStreet(address);
        currentAddress.setState(state);
        funHome.setName(funeralHome);
        employer.setCompanyName(recipEmployer);
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
        //this.state = state;
        this.currentAddress =currentAddress;
        this.funHome = funHome;
        this.employer = employer;
    }


    @Override
    public String toString(){
        return "Recipient Information: \n\nFirst Name: " + fName + "\nSocial Security Number: " + ssn + "\nPhone Number: " + phone + "\nGender: " + gender + "\nMiddle Name: " + Mname + "\nBirth Date: " + birthDate + "\nMarital Status: " + marital + "\nLast Name: " + lname + "\nMaiden Name: " + maidenName + "\nPlace of Birth: " + birthPlace + "\nState: " + currentAddress.getState() + "\nEmployer: " + employer.getCompanyName() + "\nFuneral Home: " + funHome.getName();
    }


}
