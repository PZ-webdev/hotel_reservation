package com.project.Controllers;

import com.project.Helpers.IMenu;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable, IMenu {
    public Button reservation_button;
    public Button guest_button;
    public Button room_button;
    public Button logout_button;
    public Text role;
    public Text username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set userName label with the string in login
        //  usernameLabel.setText(login.LoginController.user.getUsername());

//        if (login.LoginController.user.isIs_admin() == true) {
//            rank_Label.setText("Admin");
//        } else {
//            rank_Label.setText("Receptionist");
//        }

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
}
