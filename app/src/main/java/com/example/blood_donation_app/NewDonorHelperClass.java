package com.example.blood_donation_app;

public class NewDonorHelperClass {


        String newDonorName,newDonorID,newDonorEmail,newDonorPhone,newDonorBloodGroup,newDonorDate;


//    public NewDonorHelperClass(String newDonorName, String newDonorID, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup, String newDonorDate) {
//
//    }



    public NewDonorHelperClass(String newDonorName, String newDonorID, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup, String newDonorDate) {
        this.newDonorName = newDonorName;
        this.newDonorID = newDonorID;
        this.newDonorEmail = newDonorEmail;
        this.newDonorPhone = newDonorPhone;
        this.newDonorBloodGroup = newDonorBloodGroup;
        this.newDonorDate = newDonorDate;
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



        public String getnewDonorDate() {
            return newDonorDate;
        }

        public void setnewDonorDate(String newDonorDate) {
            this.newDonorDate = newDonorDate;
        }






}
