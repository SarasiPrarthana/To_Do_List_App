package controller;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.DashBoardInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DashBoardController implements DashBoardService{

    @Override
    public void addDashBoardDetails(String id, String title, String description, String date) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "Insert INTO Tasks VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, description);
            preparedStatement.setObject(4, date);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<DashBoardInfoDTO> loadDashBoardDetails() {
        ObservableList<DashBoardInfoDTO> dashBoardDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = ("SELECT * FROM tasks");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dashBoardDetails.add(new DashBoardInfoDTO(

                                resultSet.getString("id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getString("date")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dashBoardDetails;
    }
}
