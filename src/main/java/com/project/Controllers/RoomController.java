package com.project.Controllers;

import com.project.DAO.RoomDAO;
import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomController implements Initializable {
    public TableView<Room> tableView;
    public TableColumn<Room, Integer> idColumn;
    public TableColumn<Room, Boolean> isEmpty;
    public TableColumn<Room, String> roomCapacity;
    public TableColumn<Room, String> roomType;

    RoomDAO roomDAO = new RoomDAO();
    ObservableList<Room> roomsObList = FXCollections.observableArrayList();



    public RoomController() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
    }


    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_room"));
        isEmpty.setCellValueFactory(new PropertyValueFactory<>("is_empty"));
        roomCapacity.setCellValueFactory(new PropertyValueFactory<>("room_capacity"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
//        ownerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        vaccineColumn.setCellFactory(col -> new TableCell<>() {
//            @Override
//            protected void updateItem(Boolean item, boolean empty) {
//                super.updateItem(item, empty);
//                setText(empty ? null : item ? "Yes" : "No");
//            }
//        });
    }
    private void setObList() {
        roomsObList.clear();
        roomsObList.addAll(roomDAO.getRooms());
    }
    public void showHomeScreen(ActionEvent event) throws IOException {
        SceneController.getMainScene(event);
    }
}
