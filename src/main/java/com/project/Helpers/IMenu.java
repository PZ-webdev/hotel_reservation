package com.project.Helpers;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface IMenu {
    void showHomeScreen(ActionEvent event) throws IOException;
    void showLoginScreen(ActionEvent event) throws IOException;
    void showRoomScreen(ActionEvent event) throws IOException;
    void showGuestScreen(ActionEvent event) throws IOException;
    void showUserScreen(ActionEvent event) throws IOException;
    void showReservationScreen(ActionEvent event) throws IOException;
    void close(ActionEvent event) throws IOException;
}
