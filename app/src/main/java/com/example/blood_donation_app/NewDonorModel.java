package com.example.blood_donation_app;

public class NewDonorModel {


    String HospitalName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;
    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String HospitalName) {
        this.HospitalName = HospitalName;
    }


    String hospitalUID;
    String newDonorName;
    String newDonorID;
    String newDonorEmail;
    String newDonorPhone;
    String newDonorBloodGroup;

    public NewDonorModel(String date, String HospitalName, String hospitalUID, String newDonorName, String newDonorID, String newDonorEmail, String newDonorPhone, String newDonorBloodGroup) {
        this.newDonorName = newDonorName;
        this.newDonorID = newDonorID;
        this.newDonorEmail = newDonorEmail;
        this.newDonorPhone = newDonorPhone;
        this.newDonorBloodGroup = newDonorBloodGroup;
        this.HospitalName=HospitalName;
        this.hospitalUID = hospitalUID;
        this.date = date;

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
