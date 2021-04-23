package com.green.cinemamanagement.entity;

public class Employee {
    private int employeeID;
    private String fullName;
    private String address;
    private String phone;

    public Employee() {
    }

    public Employee(int employeeID, String fullName, String address) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
