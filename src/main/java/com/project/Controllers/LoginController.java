package com.project.Controllers;

import com.project.Models.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    //=======================
    public static Stage window;
    public static User user;
    //=======================
    @FXML
    private Button loginButton;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    //=======================
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }

    @FXML
    private void loginAction(Event event){
        System.out.println(event);
    }
}
