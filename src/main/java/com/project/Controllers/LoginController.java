package com.project.Controllers;

import com.project.DAO.UserDAO;
import com.project.Helpers.CurrentUser;
import com.project.Models.User;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    public Stage stage;
    Parent root;
    public TextField login;
    public PasswordField passwordField;
    public Button loginButton;
    public Label validLabel;

    /**
     *  Metoda odpowiadająca za zainiciajlizowanie metod podczas aktywnego widoku *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }
    /**
     *  Główna metoda odpowiadająca za logowanie do systemu.     *
     */
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

    /**
     *  Walidacja próby logowania *
     */
    private boolean validateLogin() {
        User user = UserDAO.getConnectedUser(login.getText(), passwordField.getText());
        if (user == null) {
            return false;
        }
        CurrentUser.setCurrentUser(user);
        System.out.println("Zalogowano");
        return true;
    }
    /**
     *  Walidacja pól login i hasło, czy nie są puste.    *
     */
    boolean validFields() {
        return !login.getText().isEmpty() && !passwordField.getText().isEmpty();
    }

    /**
     *  Metoda zamknięcia aplikacji.     *
     */
    public void close(ActionEvent event) throws IOException {
        SceneController.close(event);
    }
}
