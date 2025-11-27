package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.dto.DashBoardInfoDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable{

    DashBoardService dashBoardService = new DashBoardController();

    ObservableList<DashBoardInfoDTO> dashBoardInfoDTOS = FXCollections.observableArrayList();


    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<DashBoardInfoDTO> txtTbl;

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
//
        String id = txtId.getText();
        String title = txtTitle.getText();
        String description = txtDescription.getText();
        String date = txtDate.getValue().toString();

        dashBoardService.addDashBoardDetails(id,title,description,date);
        loadDashBoardDetails();
        clearFields();

        CheckBox checkBox = new CheckBox();
//        TextField newField = new TextField();
        checkBox.setText(id);
        checkBox.setStyle(
                "-fx-font-size: 18px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 6px; " +
                        "-fx-border-color: #000; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 8px;"
        );

        txtVBox.getChildren().add(checkBox);
    }

    @FXML
    void btnCompletedOnAction(ActionEvent event) {
        Iterator<Node> iterator = txtVBox.getChildren().iterator();

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof CheckBox) {
                CheckBox cb = (CheckBox) node;
                if (cb.isSelected()) {
                    iterator.remove();  // remove only selected checkbox
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadDashBoardDetails();

//        txtTbl.setItems(customerInfoDTOS);

        txtTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//
            if (newValue != null) {
                txtId.setText(newValue.getId());
                txtTitle.setText(newValue.getTitle());
                txtDescription.setText(newValue.getDescription());
                txtDate.setValue(LocalDate.parse(newValue.getDate()));

            }
        });

    }

    private void loadDashBoardDetails() {

        dashBoardInfoDTOS.clear();
        txtTbl.setItems(dashBoardService.loadDashBoardDetails());
    }

    public void clearFields(){
        txtId.clear();
        txtTitle.clear();
        txtDescription.clear();
        txtDate.setValue(null);
    }
}
