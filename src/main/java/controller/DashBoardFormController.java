package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.dto.DashBoardInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {

    DashBoardService dashBoardService = new DashBoardController();

    ObservableList<DashBoardInfoDTO> dashBoardInfoDTOS = FXCollections.observableArrayList();

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
        TextField newField = new TextField();
        newField.setPromptText("Task 1");
        txtVBox.getChildren().add(newField);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
