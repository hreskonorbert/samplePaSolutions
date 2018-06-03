package com.codecool.web.servlet;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.dao.database.DatabaseCustomerDao;
import com.codecool.web.dao.database.DatabaseEmployeeDao;
import com.codecool.web.model.Customer;
import com.codecool.web.model.Employee;
import com.codecool.web.service.simple.SimpleCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/employeeServlet")
public class EmployeeServlet extends AbstractServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection c = getConnection(req.getServletContext())) {

            DatabaseEmployeeDao eDao = new DatabaseEmployeeDao(c);


            List<Employee> allEmployee = eDao.getAllEmployee();
            sendMessage(resp, HttpServletResponse.SC_OK, allEmployee);

        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
