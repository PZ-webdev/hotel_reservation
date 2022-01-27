package com.project.Controllers;

import com.project.DAO.GuestDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Guest;
import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class GuestController  implements Initializable, IMenu {
    public TableView<Guest> tableView;
    public TableColumn<Guest, Integer> idColumn;
    public TableColumn<Guest, String> name;
    public TableColumn<Guest, Date> date_start;
    public TableColumn<Guest, Date> date_end;
    public TableColumn<Room, String> roomType;

    GuestDAO guestDAO = new GuestDAO();
    ObservableList<Guest> guestsObList = FXCollections.observableArrayList();

    public GuestController() {}

    /**
     *  Metoda inicjalizuje dodanie listy to tabeli
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
    }

    /**
     *  Dodanie danych do kolumn w tabeli
     * */
    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        date_start.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        date_end.setCellValueFactory(new PropertyValueFactory<>("date_end"));
        roomType.setCellValueFactory(new PropertyValueFactory<Room, String>("roomID"));

        tableView.setItems(getGuestsList());
    }

    /**
     *  Pobranie listy gości
     * */
    private ObservableList<Guest> getGuestsList() {
        ObservableList<Guest> consults = FXCollections.observableArrayList();
        consults.addAll(guestDAO.getGuests());
        return consults;
    }

    /**
     *  Wyczyszczenie listy, i pobranie listy gości
     * */
    private void setObList() {
        guestsObList.clear();
        guestsObList.addAll(guestDAO.getGuests());
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
}
