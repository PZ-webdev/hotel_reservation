package com.project.Helpers;

public enum ScenePath {
    LOGIN("views/login.fxml"),
    ROOM("views/room.fxml"),
    GUEST("views/guests.fxml"),
    RESERVATION("views/reservation.fxml"),
    ADD_RESERVATION("views/addReservation.fxml"),
    ADD_ROOM("views/addRoom.fxml"),
    ;
    private final String path;

    private ScenePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
