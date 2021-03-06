package com.project.Controllers;

import com.project.Helpers.ScenePath;
import com.project.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class SceneController {
    private static double x;
    private static double y;

    private static Parent main;

    /**
    *  Inicjalizacja aplikacji oraz głównego widoku, jakim jest logowanie do systemu.
     *
     * @param stage
    * */
    public static void getInitialScene(Stage stage) throws IOException {
        main = FXMLLoader.load((App.class.getResource(ScenePath.LOGIN.getPath())));
        Scene scene = new Scene(main);
        controlDrag(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hotel Reservation");
        stage.setScene(scene);
        stage.show();
    }
    /**
     *  Metoda ta zwraca widok logowania
     *
     * @param event
     * */
    public static void getLoginScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.LOGIN.getPath());
    }

    /**
     *  Metoda ta zwraca widok Pokoju
     *
     *   @param event
     * */
    public static void getRoomScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.ROOM.getPath());
    }

    /**
     *  Metoda ta zwraca widok Gości
     *
     *  @param event
     * */
    public static void getGuestScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.GUEST.getPath());
    }

    /**
     *  Metoda ta zwraca widok Rezerwacji
     *
     *  @param event
     * */
    public static void getReservationScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.RESERVATION.getPath());
    }

    /**
     *  Metoda ta zwraca widok Dodawania Rezerwacji
     *
     *  @param event
     * */
    public static void getAddReservationScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.ADD_RESERVATION.getPath());
    }

    /**
     *  Metoda ta zwraca widok Dodawania Pokoju
     *
     *  @param event
     * */
    public static void getAddRoomScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.ADD_ROOM.getPath());
    }

    /**
     *  Metoda ta zwraca widok logowania
     *
     * @param event
     * @param path
     * */
    private static void changeScreen(ActionEvent event, String path) throws IOException {
        main = FXMLLoader.load(App.class.getResource(path));
        Scene visitScene = new Scene(main);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        controlDrag(window);
        window.setScene(visitScene);
        window.show();
    }

    /**
     *  Metoda odpowiadająca za swobodne przesuwanie okna aplikacji z użyciem myszki.
     *
     * @param stage
     * */
    public static void controlDrag(Stage stage) {
        main.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = stage.getX() - event.getScreenX();
                y = stage.getY() - event.getScreenY();
            }
        });
        main.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + x);
                stage.setY(event.getScreenY() + y);
            }
        });
    }

    /**
     *  Zamknięcie aplikacji.
     *
     * @param actionEvent
     * */
    public static void close(ActionEvent actionEvent) {
        Node  source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
