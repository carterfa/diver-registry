package com.SCUBA.diver.models;

import java.util.Date;

public class Diver {
    private String name;
    private String email;
    private int age;
    private int dives;
    private Date certified;
    private String phone;
    private Boolean contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDives() {
        return dives;
    }

    public void setDives(int dives) {
        this.dives = dives;
    }

    public Date getCertified() {
        return certified;
    }

    public void setCertified(Date certified) {
        this.certified = certified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getContact() {
        return contact;
    }

    public void setContact(Boolean contact) {
        this.contact = contact;
    }
}
