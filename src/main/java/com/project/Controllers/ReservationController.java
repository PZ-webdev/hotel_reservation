package com.project.Controllers;

import com.project.DAO.ReservationDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Guest;
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
import java.util.Date;
import java.util.ResourceBundle;

public class ReservationController implements Initializable, IMenu {
    public TableView<Guest> tableView;
    public TableColumn<Guest, Integer> idColumn;
    public TableColumn<Guest, String> name;
    public TableColumn<Guest, Date> date_start;
    public TableColumn<Guest, Date> date_end;
    public TableColumn<Guest, Integer> numberOfDays;
    public TableColumn<Guest, Double> fees;

    ReservationDAO reservationDAO = new ReservationDAO();
    ObservableList<Guest> guestsObList = FXCollections.observableArrayList();

    /**
     *  Metoda inicjalizuje dodanie listy to tabeli, oraz dodanie możliwość edycji w tabeli
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setObList();
        fillTable();
        addTableSettings();
    }

    /**
     * Dodanie danych do kolumn w tabeli
     * */
    public void fillTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        date_start.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        date_end.setCellValueFactory(new PropertyValueFactory<>("date_end"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setItems(getGuestsList());
    }

    /**
     *  Pobranie listy gości
     * */
    private ObservableList<Guest> getGuestsList() {
        ObservableList<Guest> consults = FXCollections.observableArrayList();
        consults.addAll(reservationDAO.getGuests());
        return consults;
    }

    /**
     *  Dodanie opcji edycji tabeli
     * */
    private void addTableSettings() {
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     *  Wyczyszczenie listy, i pobranie listy gości
     * */
    private void setObList() {
        guestsObList.clear();
        guestsObList.addAll(reservationDAO.getGuests());
    }

    /**
     *  Zmiana nazwy w kolumnie
     * */
    public void changeNameCell(TableColumn.CellEditEvent<Guest, String> editEvent) {
        Guest selectedGuest = tableView.getSelectionModel().getSelectedItem();
        selectedGuest.setName(editEvent.getNewValue().toString());
        reservationDAO.update(selectedGuest);
    }

    /**
     *  Usuwanie zaznaczonej rezerwacji
     * */
    public void deleteReservation(ActionEvent event) throws Exception {
        ObservableList<Guest> selectedRows = tableView.getSelectionModel().getSelectedItems();
        for (Guest guest : selectedRows) {
            System.out.println(guest.getGuestID());
            reservationDAO.delete(guest);
        }
        showReservationScreen(event);
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
        SceneController.getAddReservationScene(event);
    }
}
