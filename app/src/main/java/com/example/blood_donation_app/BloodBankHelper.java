package com.example.blood_donation_app;


public class BloodBankHelper {


    public BloodBankHelper(String hospitalUID, String APositive, String ANegative, String BPositive, String BNegative, String OPositive, String ONegative,  String ABPositive,String ABNegative) {
        this.hospitalUID = hospitalUID;
        this.APositive = APositive;
        this.ANegative = ANegative;
        this.BPositive = BPositive;
        this.BNegative = BNegative;
        this.OPositive = OPositive;
        this.ONegative = ONegative;
        this.ABNegative = ABNegative;
        this.ABPositive = ABPositive;
    }

    String hospitalUID;
    String APositive,ANegative,BPositive,BNegative,OPositive,ONegative,ABNegative,ABPositive;

    public BloodBankHelper(String strAPositive, String strANegative, String strBPositive, String strBNegative, String strOPositive, String strONegative, String strABPositive, String strABNegative) {
    }

    public String getHospitalUID() {
        return hospitalUID;
    }

    public void setHospitalUID(String hospitalUID) {
        this.hospitalUID = hospitalUID;
    }


    public String getAPositive() {
        return APositive;
    }

    public void setAPositive(String APositive) {
        this.APositive = APositive;
    }

    public String getANegative() {
        return ANegative;
    }

    public void setANegative(String ANegative) {
        this.ANegative = ANegative;
    }

    public String getBPositive() {
        return BPositive;
    }

    public void setBPositive(String BPositive) {
        this.BPositive = BPositive;
    }

    public String getBNegative() {
        return BNegative;
    }

    public void setBNegative(String BNegative) {
        this.BNegative = BNegative;
    }

    public String getOPositive() {
        return OPositive;
    }

    public void setOPositive(String OPositive) {
        this.OPositive = OPositive;
    }

    public String getONegative() {
        return ONegative;
    }

    public void setONegative(String ONegative) {
        this.ONegative = ONegative;
    }

    public String getABNegative() {
        return ABNegative;
    }

    public void setABNegative(String ABNegative) {
        this.ABNegative = ABNegative;
    }

    public String getABPositive() {
        return ABPositive;
    }

    public void setABPositive(String ABPositive) {
        this.ABPositive = ABPositive;
    }





}
