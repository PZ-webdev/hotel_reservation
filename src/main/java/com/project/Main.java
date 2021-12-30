package com.project;

import com.project.Controllers.HibernateController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {

        new HibernateController().addDataToDatabase();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
//            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
    }
}