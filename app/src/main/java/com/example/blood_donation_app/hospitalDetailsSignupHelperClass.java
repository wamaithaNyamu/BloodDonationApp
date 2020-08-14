package com.example.blood_donation_app;

public class hospitalDetailsSignupHelperClass {


    String newHospitalName,newHospitalID,newHospitalEmail,newHospitalPhone,newHospitalLocation;

    public hospitalDetailsSignupHelperClass(String newHospitalName, String newHospitalID, String newHospitalEmail, String newHospitalPhone, String newHospitalLocation) {
        this.newHospitalName = newHospitalName;
        this.newHospitalID = newHospitalID;
        this.newHospitalEmail = newHospitalEmail;
        this.newHospitalPhone = newHospitalPhone;
        this.newHospitalLocation = newHospitalLocation;

    }

    public String getnewHospitalName() {

        return newHospitalName;
    }

    public void setnewHospitalName(String newHospitalName) {
        this.newHospitalName = newHospitalName;
    }



    public String getnewHospitalID() {

        return newHospitalID;
    }
    public void settnewHospitalID(String newHospitalID) {

        this.newHospitalID = newHospitalID;
    }




    public String getnewHospitalEmail() {
        return newHospitalEmail;
    }

    public void setnewHospitalEmail(String name) {
        this.newHospitalEmail = newHospitalEmail;
    }



    public String getnewHospitalPhone() {
        return newHospitalPhone;
    }

    public void setnewHospitalPhone(String newHospitalPhone) {
        this.newHospitalPhone = newHospitalPhone;
    }



    public String getnewHospitalLocation() {
        return newHospitalLocation;
    }

    public void setnewHospitalLocation(String newHospitalLocation) {
        this.newHospitalLocation = newHospitalLocation;
    }










}
