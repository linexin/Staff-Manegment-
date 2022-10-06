package com.linex.google.assignment.User;

public class User {
    private String name;
    private String dob;
    private String mobile;
    private String address;
    private String email;

    public User(String name, String dob, String mobile, String address, String email) {
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
