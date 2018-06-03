package com.codecool.web.dao;

import com.codecool.web.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers() throws SQLException;
}
