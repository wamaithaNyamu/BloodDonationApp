package com.example.blood_donation_app;
//Dataset
public class RecyclerModel {
    String date;
    String hospitalName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    String newDonorName;
    String newDonorEmail;
    String newDonorPhone;
    String newDonorBloodGroup;
    public RecyclerModel(String date, String hospitalName, String newDonorName, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup){
        this.newDonorName = newDonorName;
        this.newDonorEmail=newDonorEmail;
        this.newDonorPhone=newDonorPhone;
        this.newDonorBloodGroup=newDonorBloodGroup;
        this.date = date;
        this.hospitalName=hospitalName;

    };
    public RecyclerModel(){

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
