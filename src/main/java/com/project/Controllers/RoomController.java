package com.project.Controllers;

import com.project.DAO.RoomDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
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
    public TableColumn<Room, String> roomCapacity;
    public TableColumn<Room, String> roomType;
    public TableColumn<Room, Double> fee;

    RoomDAO roomDAO = new RoomDAO();
    ObservableList<Room> roomsObList = FXCollections.observableArrayList();

    public RoomController() {}

    /**
     *  Metoda inicjalizuje dodanie listy to tabeli, oraz dodanie możliwość edycji w tabeli
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
        addTableSettings();
    }

    /**
     *  Dodanie danych do kolumn w tabeli
     * */
    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        roomCapacity.setCellValueFactory(new PropertyValueFactory<>("room_capacity"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        fee.setCellValueFactory(new PropertyValueFactory<>("room_fee"));

        roomType.setCellFactory(TextFieldTableCell.forTableColumn());
        roomCapacity.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setItems(getRoomsList());
    }

    /**
     *  Pobranie listy pokojów
     *
     * @return liste pokojów
     * */
    private ObservableList<Room> getRoomsList() {
        ObservableList<Room> rooms = FXCollections.observableArrayList();
        rooms.addAll(roomDAO.getRooms());
        return rooms;
    }

    /**
     *  Dodanie opcji edycji tabeli
     * */
    private void addTableSettings() {
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     *  Wyczyszczenie listy, i pobranie listy pokojów
     * */
    private void setObList() {
        roomsObList.clear();
        roomsObList.addAll(roomDAO.getRooms());
    }

    /**
     *  Zmiana nazwy w kolumnie
     *
     * @param editEvent
     * */
    public void changeNameCell(TableColumn.CellEditEvent<Room, String> editEvent) {
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoom_type(editEvent.getNewValue().toString());
        roomDAO.updateRoom(selectedRoom);
    }

    /**
     *  Zmiana wielkości pokoju w kolumnie
     *
     * @param editEvent
     * */
    public void changeRoomCapacityCell(TableColumn.CellEditEvent<Room, String> editEvent) {
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoom_capacity(editEvent.getNewValue().toString());
        roomDAO.updateRoom(selectedRoom);
    }

    /**
     *  Zmiana ceny pokoju w kolumnie
     *
     * @param editEvent
     * */
    public void changeRoomFeeCell(TableColumn.CellEditEvent<Room, String> editEvent) {
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoom_fee(Double.parseDouble(editEvent.getNewValue().toString()));
        roomDAO.updateRoom(selectedRoom);
    }

    /**
     *  Usuwanie zaznaczonego pokoju
     *
     * @param event
     * */
    public void deleteRooms(ActionEvent event) throws Exception {
        ObservableList<Room> selectedRows = tableView.getSelectionModel().getSelectedItems();
        for (Room room : selectedRows) {
            System.out.println(room.getRoomID());
            roomDAO.delete(room);
        }
        showRoomScreen(event);
    }

    /**
     *  Przesłonięte metody do zmiany scen
     * */
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

    public void showAddRoom(ActionEvent event) throws IOException {
        SceneController.getAddRoomScene(event);
    }
}
