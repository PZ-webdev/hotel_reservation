package com.project.Controllers;

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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public static Stage window;
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
           Parent view = FXMLLoader.load(getClass().getResource("/home.fxml"));
//           Parent view = FXMLLoader.load(getClass ().getClassLoader().getResource( "com/project/home.fxml"));
           Scene scene = new Scene(view);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();


        } catch (IOException ex) {
            System.out.println("Error load homePage FXML !");
            System.out.println(ex);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
