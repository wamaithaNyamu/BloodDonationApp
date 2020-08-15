package com.example.blood_donation_app;

public class hospitalProfileHelper {
    public hospitalProfileHelper(String newHospitalName, String newHospitalID, String newHospitalEmail, String newHospitalPhone, String newHospitalLocation) {
        this.newHospitalName = newHospitalName;
        this.newHospitalID = newHospitalID;
        this.newHospitalEmail = newHospitalEmail;
        this.newHospitalPhone = newHospitalPhone;
        this.newHospitalLocation = newHospitalLocation;
    }

    public String getNewHospitalName() {
        return newHospitalName;
    }

    public void setNewHospitalName(String newHospitalName) {
        this.newHospitalName = newHospitalName;
    }

    public String getNewHospitalID() {
        return newHospitalID;
    }

    public void setNewHospitalID(String newHospitalID) {
        this.newHospitalID = newHospitalID;
    }

    public String getNewHospitalEmail() {
        return newHospitalEmail;
    }

    public void setNewHospitalEmail(String newHospitalEmail) {
        this.newHospitalEmail = newHospitalEmail;
    }

    public String getNewHospitalPhone() {
        return newHospitalPhone;
    }

    public void setNewHospitalPhone(String newHospitalPhone) {
        this.newHospitalPhone = newHospitalPhone;
    }

    public String getNewHospitalLocation() {
        return newHospitalLocation;
    }

    public void setNewHospitalLocation(String newHospitalLocation) {
        this.newHospitalLocation = newHospitalLocation;
    }

    String newHospitalName,newHospitalID,newHospitalEmail,newHospitalPhone,newHospitalLocation;

}
