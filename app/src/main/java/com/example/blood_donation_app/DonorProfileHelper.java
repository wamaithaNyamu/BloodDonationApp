package com.example.blood_donation_app;

public class DonorProfileHelper {
    public DonorProfileHelper(String newDonorName, String newDonorID, String newDonorEmail, String newDonorPhone, String newDonorLocation) {
        this.newDonorName = newDonorName;
        this.newDonorID = newDonorID;
        this.newDonorEmail = newDonorEmail;
        this.newDonorPhone = newDonorPhone;
        this.newDonorLocation = newDonorLocation;
    }

    public String getNewDonorName() {
        return newDonorName;
    }

    public void setNewDonorName(String newDonorName) {
        this.newDonorName = newDonorName;
    }

    public String getNewDonorID() {
        return newDonorID;
    }

    public void setNewDonorID(String newDonorID) {
        this.newDonorID = newDonorID;
    }

    public String getNewDonorEmail() {
        return newDonorEmail;
    }

    public void setNewDonorEmail(String newDonorEmail) {
        this.newDonorEmail = newDonorEmail;
    }

    public String getNewDonorPhone() {
        return newDonorPhone;
    }

    public void setNewDonorPhone(String newDonorPhone) {
        this.newDonorPhone = newDonorPhone;
    }

    public String getNewDonorLocation() {
        return newDonorLocation;
    }

    public void setNewDonorLocation(String newDonorLocation) {
        this.newDonorLocation = newDonorLocation;
    }

    String newDonorName,newDonorID,newDonorEmail,newDonorPhone,newDonorLocation;

}
