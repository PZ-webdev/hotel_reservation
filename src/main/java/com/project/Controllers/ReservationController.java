package com.project.Controllers;

import com.project.DAO.ReservationDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Guest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ReservationController implements Initializable, IMenu {
    ReservationDAO guestDAO = new ReservationDAO();
    ObservableList<Guest> guestsObList = FXCollections.observableArrayList();
    public TableView<Guest> tableView;
    public TableColumn<Guest, Integer> idColumn;
    public TableColumn<Guest, String> name;
    public TableColumn<Guest, Date> date_start;
    public TableColumn<Guest, Date> date_end;
    public TableColumn<Guest, Integer> numberOfDays;
    public TableColumn<Guest, Double> fees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
    }
    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        date_start.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        date_end.setCellValueFactory(new PropertyValueFactory<>("date_end"));
//        roomType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        numberOfDays.setCellValueFactory(new PropertyValueFactory<>("numberOfDays"));
        fees.setCellValueFactory(new PropertyValueFactory<>("fees"));

        tableView.setItems(getGuestsList());
    }
    private ObservableList<Guest> getGuestsList() {
        ObservableList<Guest> consults = FXCollections.observableArrayList();
        consults.addAll(guestDAO.getGuests());
        return consults;
    }

    private void addTableSettings() {
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        tableView.setItems(getSortedList());
    }

    private void setObList() {
        guestsObList.clear();
        guestsObList.addAll(guestDAO.getGuests());
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
        System.out.println("Pokaz dodawanie rezerwacji");
        SceneController.getAddReservationScene(event);
    }
}