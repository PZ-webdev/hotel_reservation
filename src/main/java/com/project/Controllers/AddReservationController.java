package com.project.Controllers;

import com.project.DAO.GuestDAO;
import com.project.DAO.RoomDAO;
import com.project.Helpers.IMenu;
import com.project.Models.Guest;
import com.project.Models.Room;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AddReservationController implements Initializable, IMenu {
    RoomDAO roomDAO = new RoomDAO();
    ObservableList<Room> roomsObList = FXCollections.observableArrayList();
    public ComboBox<Room> roomSelect;
    public DatePicker dateStart;
    public DatePicker dateEnd;
    public TextField name;
    public TextField email;
    public TextField phone;
    public TextField fee;
    public Label textValidLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      roomSelect.setItems(getRoomObList());
      regex();
    }

    private ObservableList<Room> getRoomObList() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(roomDAO.getRooms());
        return list;
    }

    public void saveNewGuestToDb(ActionEvent event) throws IOException {
        if(validateInputs()) {
            Guest guest = createGuestFromInput();

            boolean isSaved = new GuestDAO().create(guest);
            if (isSaved) {
                textValidLabel.setText("Dodano Rezerwację");
                delayWindowClose(event);
            }
        }
    }

    private boolean validateInputs() {

        if (dateStart.getValue() == null) {
            textValidLabel.setText("Zaznacz datę początkową rezerwacji!");
            return false;
        }

        if(dateEnd.getValue() == null) {
            textValidLabel.setText("Zaznacz datę końcową rezerwacji!");
            return false;
        }
        if(!dateEnd.getValue().isAfter(dateStart.getValue())) {
            textValidLabel.setText("Data Zakończenia musi być poźniejsza niż rozpoczęcia");
            return false;
        }

        if(name.getText().equals("")) {
            textValidLabel.setText("Wprowadź imię i nazwisko!");
            return false;
        }

        if (email.getText().equals("")) {
            textValidLabel.setText("Podaj adres E-mail");
            return false;
        }

        if (phone.getText().equals("")) {
            textValidLabel.setText("Podaj adres nr. telefonu");
            return false;
        }
        if (fee.getText().equals("")) {
            textValidLabel.setText("Podaj zaliczkę");
            return false;
        }
        if (parseInt(fee.getText()) < 0) {
            textValidLabel.setText("Zaliczka musi być większa od zera!");
            return false;
        }
        return true;
    }

    private Guest createGuestFromInput() {
        Guest guest = new Guest();
        guest.setDate_end(dateEnd.getValue());
        guest.setDate_start(dateStart.getValue());
        guest.setName(name.getText());
        guest.setEmail(email.getText());
        guest.setFees(Double.parseDouble(fee.getText()));
        guest.setPhone(Long.parseLong(phone.getText()));
        return guest;
    }

    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event2 -> {
            try {
                showReservationScreen(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();
    }

    public void clear(){
        dateStart.getEditor().clear();
        dateEnd.getEditor().clear();
        name.clear();
        email.clear();
        phone.clear();
        fee.clear();
    }

    private void regex(){
        name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\D*")) {
                    name.setText(newValue.replaceAll("[^\\D]", ""));
                }
            }
        });

        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        fee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fee.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
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
