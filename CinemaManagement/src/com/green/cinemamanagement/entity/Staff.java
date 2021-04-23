package com.green.cinemamanagement.entity;

public class Staff {
    private int id;
    private String fullName;
    private String gender;
    private String address;
    private String phone;

    public Staff() {
    }

    public Staff(int id, String fullName, String gender, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public Staff(String fullName, String gender, String address, String phone) {

        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
