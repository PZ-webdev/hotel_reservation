package com.project.Controllers;

import com.project.Models.Room;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class RoomController implements Initializable {
    private TableView tableView;
    private final static Logger LOG = Logger.getLogger(String.valueOf(RoomController.class));
    public RoomController() {}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
    }


    public void updateList() {
        //
    }
}
