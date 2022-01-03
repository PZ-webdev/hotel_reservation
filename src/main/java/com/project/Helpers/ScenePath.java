package com.project.Helpers;

public enum ScenePath {
    HOME("home.fxml"),
    LOGIN("login.fxml"),
    ROOM("room.fxml"),
    GUEST("guests.fxml"),
    USERS("users.fxml"),
    RESERVATION("reservation.fxml"),
    ADD_RESERVATION("addReservation.fxml"),
    ;
    private final String path;

    private ScenePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
