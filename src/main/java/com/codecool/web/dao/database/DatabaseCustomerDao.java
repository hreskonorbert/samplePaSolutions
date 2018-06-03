package com.codecool.web.dao.database;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCustomerDao extends AbstractDao implements CustomerDao {

    public DatabaseCustomerDao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> result = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchCustomer(resultSet));
                }
            }
        }
        return result;
    }

    public Customer fetchCustomer(ResultSet rs) throws SQLException {
        int id=rs.getInt("Customerid");
        String firstName = rs.getString("FirstName");
        String lastName = rs.getString("LastName");
        String company = rs.getString("Company");
        String fullAddress = rs.getString("Address")+","+rs.getString("City")+","+rs.getString("State")+","+rs.getString("Country")+","+rs.getString("PostalCode");
        String phone=rs.getString("Phone");
        String fax = rs.getString("Fax");
        String email = rs.getString("Email");
        int supportRepId = rs.getInt("SupportRepId");

        return new Customer(id,firstName,lastName,company,fullAddress,phone,fax,email,supportRepId);


    }
}
