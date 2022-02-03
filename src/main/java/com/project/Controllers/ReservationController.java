package com.project.Controllers;

import com.project.DAO.ReservationDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Guest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    public TableColumn<Guest, Double> price;
    public TextField searchBar;

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
        numberOfDays.setCellValueFactory(new PropertyValueFactory("days"));
        price.setCellValueFactory(new PropertyValueFactory("priceReservation"));

        name.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setItems(getGuestsList());
    }

    /**
     *  Pobranie listy gości
     *
     * @return listę gosci
     * */
    private ObservableList<Guest> getGuestsList() {
        ObservableList<Guest> guests = FXCollections.observableArrayList();
        guests.addAll(reservationDAO.getGuests());
        return guests;
    }

    /**
     *  Dodanie opcji edycji tabeli
     * */
    private void addTableSettings() {
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setItems(getFilteredList());
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
     *
     * @param editEvent
     * */
    public void changeNameCell(TableColumn.CellEditEvent<Guest, String> editEvent) {
        Guest selectedGuest = tableView.getSelectionModel().getSelectedItem();
        selectedGuest.setName(editEvent.getNewValue().toString());
        reservationDAO.update(selectedGuest);
    }

    /**
     *  Usuwanie zaznaczonej rezerwacji
     *
     * @param event
     * */
    public void deleteReservation(ActionEvent event) throws Exception {
        ObservableList<Guest> selectedRows = tableView.getSelectionModel().getSelectedItems();
        for (Guest guest : selectedRows) {
            System.out.println(guest.getGuestID());
            reservationDAO.delete(guest);
        }
        showReservationScreen(event);
    }

    private FilteredList<Guest> getFilteredList() {
        FilteredList<Guest> filteredList = new FilteredList<>(guestsObList, b -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) ->
                filteredList.setPredicate(guest -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                        if(guest.getName().toLowerCase().contains(lowerCaseFilter)){
                            return true;
                        }
                        else return guest.toString().contains(lowerCaseFilter);
                }));
        return filteredList;
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
