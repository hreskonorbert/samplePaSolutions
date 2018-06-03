package com.codecool.web.model;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private int supportRepId;

    public Customer(int id, String firstName, String lastName, String company, String address, String phone, String fax, String email, int supportRepId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.supportRepId = supportRepId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public int getSupportRepId() {
        return supportRepId;
    }
}
