package com.example.blood_donation_app;


public class BloodBankHelper {


    public BloodBankHelper(String HospitalName, int APositive, int ANegative, int BPositive, int BNegative, int OPositive, int ONegative,  int ABPositive,int ABNegative) {
        this.HospitalName = HospitalName;
        this.APositive = APositive;
        this.ANegative = ANegative;
        this.BPositive = BPositive;
        this.BNegative = BNegative;
        this.OPositive = OPositive;
        this.ONegative = ONegative;
        this.ABNegative = ABNegative;
        this.ABPositive = ABPositive;
    }

    String HospitalName;
    int APositive,ANegative,BPositive,BNegative,OPositive,ONegative,ABNegative,ABPositive;

    public BloodBankHelper(int strAPositive, int strANegative, int strBPositive, int strBNegative, int strOPositive, int strONegative, int strABPositive, int strABNegative) {
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String HospitalName) {
        this.HospitalName = HospitalName;
    }


    public int getAPositive() {
        return APositive;
    }

    public void setAPositive(int APositive) {
        this.APositive = APositive;
    }

    public int getANegative() {
        return ANegative;
    }

    public void setANegative(int ANegative) {
        this.ANegative = ANegative;
    }

    public int getBPositive() {
        return BPositive;
    }

    public void setBPositive(int BPositive) {
        this.BPositive = BPositive;
    }

    public int getBNegative() {
        return BNegative;
    }

    public void setBNegative(int BNegative) {
        this.BNegative = BNegative;
    }

    public int getOPositive() {
        return OPositive;
    }

    public void setOPositive(int OPositive) {
        this.OPositive = OPositive;
    }

    public int getONegative() {
        return ONegative;
    }

    public void setONegative(int ONegative) {
        this.ONegative = ONegative;
    }

    public int getABNegative() {
        return ABNegative;
    }

    public void setABNegative(int ABNegative) {
        this.ABNegative = ABNegative;
    }

    public int getABPositive() {
        return ABPositive;
    }

    public void setABPositive(int ABPositive) {
        this.ABPositive = ABPositive;
    }





}
