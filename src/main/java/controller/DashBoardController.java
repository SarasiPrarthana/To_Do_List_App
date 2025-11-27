package controller;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DashBoardController implements DashBoardService{

//    @Override
//    public void addDashBoardDetails(String id, String title, String description, String date) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//
//            String SQL = "Insert INTO DashBoard VALUES(?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//
//            preparedStatement.setObject(1, id);
//            preparedStatement.setObject(2, title);
//            preparedStatement.setObject(3, description);
//            preparedStatement.setObject(4, date);
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
