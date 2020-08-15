package com.example.blood_donation_app;
//Dataset
public class RecyvlerModel {
    String newDonorName,newDonorEmail,newDonorPhone, newDonorBloodGroup;
    public RecyvlerModel (String newDonorName, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup){
        this.newDonorName = newDonorName;
        this.newDonorEmail=newDonorEmail;
        this.newDonorPhone=newDonorPhone;
        this.newDonorBloodGroup=newDonorBloodGroup;


    };
    public RecyvlerModel(){

    }

    public String getnewDonorName() {
        return newDonorName;
    }

    public void setnewDonorName(String newDonorName) {
        this.newDonorName = newDonorName;
    }

    public String getnewDonorEmail() {
        return newDonorEmail;
    }

    public void setnewDonorEmail(String newDonorEmail) {
        this.newDonorEmail = newDonorEmail;
    }

    public String getnewDonorPhone() {
        return newDonorPhone;
    }

    public void setnewDonorPhone(String newDonorPhone) {
        this.newDonorPhone = newDonorPhone;
    }

    public String getnewDonorBloodGroup() {
        return newDonorBloodGroup;
    }

    public void setnewDonorBloodGroup(String newDonorBloodGroup) {
        this.newDonorBloodGroup = newDonorBloodGroup;
    }

}
