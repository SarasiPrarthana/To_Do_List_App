package controller;

import javafx.collections.ObservableList;
import model.dto.DashBoardInfoDTO;

import java.util.Date;

public interface DashBoardService {

    void addDashBoardDetails(String id, String title, String description,String date);

    ObservableList<DashBoardInfoDTO> loadDashBoardDetails();
}
