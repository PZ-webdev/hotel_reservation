package com.project;

import com.project.Controllers.HibernateController;
import com.project.Controllers.SceneController;
import com.project.DAO.SingletonConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        Session session = SingletonConnection.getSessionFactory().openSession();
        new HibernateController().addDataToDatabase();
        session.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        SceneController.getInitialScene(stage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        SingletonConnection.getSessionFactory().close();
    }
}