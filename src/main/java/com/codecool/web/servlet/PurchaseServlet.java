package com.codecool.web.servlet;

import com.codecool.web.dao.database.DatabaseEmployeeDao;
import com.codecool.web.dao.database.DatabasePurchaseDao;
import com.codecool.web.model.Employee;
import com.codecool.web.model.Purchase;
import com.codecool.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/purchaseServlet")
public class PurchaseServlet extends AbstractServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection c = getConnection(req.getServletContext())) {

            DatabasePurchaseDao pDao = new DatabasePurchaseDao(c);

            User user = (User)req.getSession().getAttribute("user");
            List<Purchase> purchaseHistory = pDao.getDetailedPurchaseHistory(user.getId());
            sendMessage(resp, HttpServletResponse.SC_OK, purchaseHistory);

        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
