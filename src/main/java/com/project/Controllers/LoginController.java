package com.project.Controllers;

import com.project.DAO.UserDAO;
import com.project.Helpers.CurrentUser;
import com.project.Main;
import com.project.Models.User;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.Window;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    public Stage stage;
    Parent root;
    public TextField login;
    public PasswordField passwordField;
    public Button loginButton;
    public Label validLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }

    @FXML
    public void loginAction(Event event){
        String user = login.getText();
        String pass = passwordField.getText();

        if(!validFields()) {
            validLabel.setText("Login i Hasło muszą być wypełnione !");
            validLabel.setVisible(true);

            System.out.println("Username and password can't be empty!");
            return;
        }

        if (!validateLogin()) {
            validLabel.setText("Niepoprawne dane logowania");
            validLabel.setVisible(true);

            System.out.println("User not found");
            return;
        }

        validLabel.setStyle("-fx-text-inner-color: green;");
        validLabel.setText("Zalogowano !");
        validLabel.setVisible(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished( event2 -> {
            try {
                SceneController.getGuestScene((ActionEvent) event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();

    }

    private boolean validateLogin() {
        User user = UserDAO.getConnectedUser(login.getText(), passwordField.getText());
        if (user == null) {
            return false;
        }
        CurrentUser.setCurrentUser(user);
        System.out.println("Zalogowano");
        return true;
    }

    boolean validFields() {
        return !login.getText().isEmpty() && !passwordField.getText().isEmpty();
    }

    public void close(ActionEvent event) throws IOException {
        SceneController.close(event);
    }
}
