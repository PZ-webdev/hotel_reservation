package com.project.Controllers;

import com.project.Helpers.IMenu;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable, IMenu {
    public Button reservation_button;
    public Button guest_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       //
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
