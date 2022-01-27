package com.project.Controllers;

import com.project.DAO.RoomDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Room;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AddRoomController implements Initializable, IMenu {
    public TextField roomFee;
    public ComboBox roomCapacity;
    public ComboBox roomType;
    public Label textValidLabel;

    /**
     *  Metoda inicjalizuje listę wielkości pokoju oraz jego rodzaj
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initRoomCapacitySelectList();
        initRoomTypeSelectList();
    }

    /**
     *  Metoda dodająca rodzaj pokoju do listy
     * */
    private void initRoomTypeSelectList() {
        List<String> list = new ArrayList<String>();
        list.add("Normal");
        list.add("Economy");
        list.add("VIP");
        list.add("SUPER VIP");
        ObservableList obList = FXCollections.observableList(list);
        roomType.getItems().clear();
        roomType.setItems(obList);
    }

    /**
     *  Metoda dodająca wielkość pokoju do listy
     * */
    private void initRoomCapacitySelectList() {
        List<String> list = new ArrayList<String>();
        list.add("Single");
        list.add("Double");
        list.add("Triple");
        ObservableList obList = FXCollections.observableList(list);
        roomCapacity.getItems().clear();
        roomCapacity.setItems(obList);
    }

    /**
     *  Metoda wywołująca metode do zapisania nowo utworzonego pokoju do bazy danych
     * */
    public void saveNewRoomToDb(ActionEvent event) throws IOException {
        if(validateInputs()) {
        Room room = createRoomFromInput();
            boolean isSaved = new RoomDAO().create(room);
        System.out.println(isSaved);
            if (isSaved) {
                textValidLabel.setText("Dodano Pokój");
                delayWindowClose(event);
            }
        }
    }

    /**
     *  Walidacja dodawanego pokoju
     * */
    private boolean validateInputs() {
        if (roomCapacity.getValue() == null) {
            textValidLabel.setText("Wybierz Wielkość pokoju!");
            return false;
        }
        if (roomType.getValue() == null) {
            textValidLabel.setText("Wybierz rodzaj pokoju!");
            return false;
        }
        if (roomFee.getText().equals("")) {
            textValidLabel.setText("Wprowadź cenę pokoju!");
            return false;
        }
        if (parseInt(roomFee.getText()) < 0) {
            textValidLabel.setText("Wprowadzona cena nie może być mniejsza od zera!");
            return false;
        }
        return true;
    }

    /**
     *  Zapisywanie do bazy danych nowo utworzonego pokoju
     * */
    private Room createRoomFromInput() {
        Room room = new Room();
        room.setRoom_fee(Double.parseDouble(roomFee.getText()));
        room.setRoom_capacity((String) roomCapacity.getValue());
        room.setRoom_type((String) roomType.getValue());
        return room;
    }

    /**
     *  Opoźnienie 2s po poprawnym dodaniu pokoju
     * */
    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event2 -> {
            try {
                showRoomScreen(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();
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
