package com.codecool.web.model;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;

    private String address;
    private String phone;
    private String fax;
    private String email;


    public Employee(int id, String firstName, String lastName,  String address, String phone, String fax, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.email = email;

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

}
