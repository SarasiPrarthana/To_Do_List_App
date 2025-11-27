package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.dto.DashBoardInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController {

    private int counter = 1;

//    DashBoardService dashBoardService = new DashBoardController();
//
//    ObservableList<DashBoardInfoDTO> dashBoardInfoDTOS = FXCollections.observableArrayList();

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNew;

    @FXML
    private TextField txtTitle;

    @FXML
    private VBox txtVBox;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        CheckBox checkBox = new CheckBox();
//        TextField newField = new TextField();
        checkBox.setText("Task " + counter);
        checkBox.setStyle(
                "-fx-font-size: 18px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 6px; " +
                        "-fx-border-color: #000; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 8px;"
        );

        txtVBox.getChildren().add(checkBox);

        counter++;
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
}
