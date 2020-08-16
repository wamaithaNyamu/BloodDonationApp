package com.example.blood_donation_app;

public class SliderModel {
    public SliderModel(String Letter , String HospitalName,int APositive, int ANegative, int BPositive, int BNegative, int ABPositive, int ABNegative, int OPositive, int ONegative) {
        this.APositive = APositive;
        this.ANegative = ANegative;
        this.BPositive = BPositive;
        this.BNegative = BNegative;
        this.ABPositive = ABPositive;
        this.ABNegative = ABNegative;
        this.OPositive = OPositive;
        this.ONegative = ONegative;
        this.HospitalName = HospitalName;
        this.Letter = Letter;
    }
    public SliderModel(){}

    String HospitalName;

    public String getLetter() {
        return Letter;
    }

    public void setLetter(String letter) {
        Letter = letter;
    }

    String Letter;
    int APositive;
    int ANegative;
    int BPositive;
    int BNegative;
    int ABPositive;
    int ABNegative;
    int OPositive;
    int ONegative;

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
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

    public int getABPositive() {
        return ABPositive;
    }

    public void setABPositive(int ABPositive) {
        this.ABPositive = ABPositive;
    }

    public int getABNegative() {
        return ABNegative;
    }

    public void setABNegative(int ABNegative) {
        this.ABNegative = ABNegative;
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
}
