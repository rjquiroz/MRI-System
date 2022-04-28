package mriSystem;

import java.util.Date;

public class InforcePolicy {
    private Recipient recipient;
    private String policyNumber;
    private double faceValue;
    private InsuranceCompany provider;
    private String policyType;
    private String policyDesignation;
    private boolean isTherePremium;
    private double premiumAmount;

    private String status;

    private Date dueOn;

    private Beneficiary beneficiary;

    private String mqy;


    public InforcePolicy(){
        
    }
    
    public InforcePolicy(Recipient recipient, String policyNumber, double faceValue, InsuranceCompany provider, String policyType, String policyDesignation, boolean isTherePremium, double premiumAmount, String status, Date dueOn, Beneficiary beneficiary, String mqy){
        this.recipient = recipient;
        this.policyNumber = policyNumber;
        this.faceValue = faceValue;
        this.provider = provider;
        this.policyType = policyType;
        this.policyDesignation = policyDesignation;
        this.isTherePremium = isTherePremium;
        this.premiumAmount = premiumAmount;
        this.status = status;
        this.dueOn = dueOn;
        this.beneficiary = beneficiary;
        this.mqy = mqy;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public InsuranceCompany getProvider() {
        return provider;
    }

    public String getPolicyType() {
        return policyType;
    }

    public String getPolicyDesignation() {
        return policyDesignation;
    }

    public boolean getIsTherePremium() {
        return isTherePremium;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public String getStatus() {
        return status;
    }

    public Date getDueOn() {
        return dueOn;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public String getMqy() {
        return mqy;
    }
}
