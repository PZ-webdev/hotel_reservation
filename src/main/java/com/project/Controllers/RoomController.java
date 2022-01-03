package com.project.Controllers;

import com.project.DAO.RoomDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomController implements Initializable, IMenu {
    public TableView<Room> tableView;
    public TableColumn<Room, Integer> idColumn;
    public TableColumn<Room, Boolean> isEmpty;
    public TableColumn<Room, String> roomCapacity;
    public TableColumn<Room, String> roomType;
    public TableColumn<Room, Double> fee;

    RoomDAO roomDAO = new RoomDAO();
    ObservableList<Room> roomsObList = FXCollections.observableArrayList();

    public RoomController() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
        addTableSettings();
    }

    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        isEmpty.setCellValueFactory(new PropertyValueFactory<>("is_empty"));
        roomCapacity.setCellValueFactory(new PropertyValueFactory<>("room_capacity"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        fee.setCellValueFactory(new PropertyValueFactory<>("room_fee"));
        roomType.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setItems(getRoomsList());
    }
    private ObservableList<Room> getRoomsList() {
        ObservableList<Room> consults = FXCollections.observableArrayList();
        consults.addAll(roomDAO.getRooms());
        return consults;
    }

    private void addTableSettings() {
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void setObList() {
        roomsObList.clear();
        roomsObList.addAll(roomDAO.getRooms());
    }


    public void changeNameCell(TableColumn.CellEditEvent<Room, String> editEvent) {
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoom_type(editEvent.getNewValue().toString());
        roomDAO.updateRoom(selectedRoom);
    }


    @Override
    public void showHomeScreen(ActionEvent event) throws IOException {
        SceneController.getHomeScene(event);
    }

    @Override
    public void showLoginScreen(ActionEvent event) throws IOException {
        SceneController.getLoginScene(event);
    }

    @Override
    public void showRoomScreen(ActionEvent event) throws IOException {
        SceneController.getRoomScene(event);
    }

    @Override
    public void showGuestScreen(ActionEvent event) throws IOException {
        SceneController.getGuestScene(event);
    }

    @Override
    public void showUserScreen(ActionEvent event) throws IOException {
        SceneController.getUserScene(event);
    }

    @Override
    public void showReservationScreen(ActionEvent event) throws IOException {
        SceneController.getReservationScene(event);
    }

    @Override
    public void close(ActionEvent event) throws IOException {
        SceneController.close(event);
    }

    @Override
    public void showAddReservation(ActionEvent event) throws IOException {
        //
    }
}
