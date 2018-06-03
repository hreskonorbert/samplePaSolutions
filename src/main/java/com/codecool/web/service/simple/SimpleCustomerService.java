package com.codecool.web.service.simple;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class SimpleCustomerService {

    private final CustomerDao customerDao;

    public SimpleCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() throws SQLException {
       return customerDao.getAllCustomers();
    }
}
