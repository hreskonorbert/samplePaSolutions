package com.codecool.web.dao.database;

import com.codecool.web.model.Employee;
import com.codecool.web.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePurchaseDao extends AbstractDao{

    public DatabasePurchaseDao(Connection connection) {
        super(connection);
    }



    public List<Purchase> getDetailedPurchaseHistory(int userId) throws SQLException {
        List<Purchase> result = new ArrayList<>();
        String sql = "SELECT invoiceline.invoiceid ,invoiceline.unitprice, track.name AS trackName, album.title AS albumtitle, artist.name AS artist, genre.name " +
            "FROM invoice " +
            "JOIN invoiceline ON invoiceline.invoiceid = invoice.invoiceid " +
            "JOIN track ON track.trackid = invoiceline.trackid " +
            "JOIN album ON track.albumid = album.albumid " +
            "JOIN artist ON artist.artistid = album.artistid " +
            "JOIN genre ON track.genreid = genre.genreid " +
            "WHERE invoice.customerid = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchPurchase(resultSet));
                }
            }
        }
        return result;
    }

    public Purchase fetchPurchase(ResultSet rs) throws SQLException {
        int invoiceid=rs.getInt("invoiceid");
        String artist = rs.getString("artist");
        String album = rs.getString("albumtitle");

        String track = rs.getString("trackname");
        int price=rs.getInt("unitprice");
        String genre = rs.getString("name");



        return new Purchase(invoiceid,artist,album,track,price,genre);


    }
}
