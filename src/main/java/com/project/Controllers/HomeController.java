package com.project.Controllers;

import com.project.Models.User;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
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
}
