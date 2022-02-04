package com.project;

import com.project.Controllers.HibernateController;
import com.project.Controllers.SceneController;
import com.project.DAO.HibernateConnection;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        Session session = HibernateConnection.getSessionFactory().openSession();
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
        HibernateConnection.getSessionFactory().close();
    }
}