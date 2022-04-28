package mriSystem;

public class Report {
    private String fName;
    private String lName;
    private String state;
    private String ssn;
    private String lifeCompany;
    private String policyNumber;
    private String policyType;
    private double faceAmount;

    private double benefitPayouts;
    private double balance;

    private double totalFaceAmount;

    private String annuityCompany;

    private int id;


    public Report(){

    }

    public Report(String fName, String lName,String ssn, String state, int id,String lifeCompany, String policyNumber,String policyType,double faceAmount, double benefitPayouts, double totalFaceAmount, String annuityCompany){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.ssn = ssn;
        this.state = state;
        this.lifeCompany = lifeCompany;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.faceAmount = faceAmount;
        this.benefitPayouts = benefitPayouts;
        this.totalFaceAmount = totalFaceAmount;
        this.annuityCompany = annuityCompany;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getState() {
        return state;
    }

    public String getSsn() {
        return ssn;
    }

    public String getLifeCompany() {
        return lifeCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getFaceAmount() {
        return faceAmount;
    }

    public double getBenefitPayouts() {
        return benefitPayouts;
    }

    public double getBalance() {
        return balance;
    }

    public void calculateBalance(double faceValue, double benefitPayouts){
         balance = faceValue - benefitPayouts;
    }

    public double getTotalFaceAmount() {
        return totalFaceAmount;
    }

    public String getAnnuityCompany() {
        return annuityCompany;
    }

    public int getId() {
        return id;
    }

}
