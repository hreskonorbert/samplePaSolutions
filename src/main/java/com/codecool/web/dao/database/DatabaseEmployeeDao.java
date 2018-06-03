package com.codecool.web.dao.database;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseEmployeeDao extends AbstractDao{

    public DatabaseEmployeeDao(Connection connection) {
        super(connection);
    }



    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> result = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchEmployee(resultSet));
                }
            }
        }
        return result;
    }

    public Employee fetchEmployee(ResultSet rs) throws SQLException {
        int id=rs.getInt("Employeeid");
        String firstName = rs.getString("FirstName");
        String lastName = rs.getString("LastName");

        String fullAddress = rs.getString("Address")+","+rs.getString("City")+","+rs.getString("State")+","+rs.getString("Country")+","+rs.getString("PostalCode");
        String phone=rs.getString("Phone");
        String fax = rs.getString("Fax");
        String email = rs.getString("Email");


        return new Employee(id,firstName,lastName,fullAddress,phone,fax,email);


    }
}
