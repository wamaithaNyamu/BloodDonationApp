package com.example.blood_donation_app;

public class NewDonorHelperClass {


    String hospitalUID , newDonorName,newDonorID,newDonorEmail,newDonorPhone,newDonorBloodGroup;

    public NewDonorHelperClass( String hospitalUID, String newDonorName, String newDonorID, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup) {
        this.newDonorName = newDonorName;
        this.newDonorID = newDonorID;
        this.newDonorEmail = newDonorEmail;
        this.newDonorPhone = newDonorPhone;
        this.newDonorBloodGroup = newDonorBloodGroup;

        this.hospitalUID = hospitalUID;

    }




    public String gethospitalUID() {
        return hospitalUID;
    }

    public void sethospitalUID(String hospitalUID) {
        this.hospitalUID = hospitalUID;
    }




    public String getnewDonorName() {

        return newDonorName;
        }

        public void setnewDonorName(String newDonorName) {
            this.newDonorName = newDonorName;
        }



        public String getnewDonorID() {

        return newDonorID;
        }
        public void settnewDonorID(String newDonorID) {

        this.newDonorID = newDonorID;
        }




        public String getnewDonorEmail() {
            return newDonorEmail;
        }

        public void setnewDonorEmail(String name) {
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
