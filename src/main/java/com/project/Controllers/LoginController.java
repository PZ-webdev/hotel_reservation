package com.project.Controllers;

import com.project.Main;
import com.project.Models.User;
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
        ConnectorController connect = new ConnectorController();
        Connection connectDB = connect.getConnection();
//        String query = "SELECT * FROM users WHERE login = '" + login.getText() +"' AND password = '" + passwordField.getText() + "'";
        String query = "SELECT * FROM users WHERE login = 'janek233'  AND password = 'password'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(!resultSet.next()) {
                System.out.println("Niepoprane dane uzytkownika");

                validLabel.setText("Niepoprawne dane logowania");
                validLabel.setVisible(true);

            }else{
                System.out.println("== ZALOGOWANO ==");
                validLabel.setVisible(false);
                goToHomePage(event);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToHomePage(Event event) {
        try {
            stage = (Stage) loginButton.getScene().getWindow();
            root =  FXMLLoader.load(Main.class.getResource("room.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error load homePage FXML !");
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
