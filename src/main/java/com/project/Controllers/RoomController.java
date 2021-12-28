package com.project.Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RoomController implements Initializable {
    private ObservableList<ObservableList> data;
    private TableView tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public RoomController() {}

    public void getRooms() {
        ConnectorController connect = new ConnectorController();
        Connection connectDB = connect.getConnection();
        String query = "SELECT * FROM rooms";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            //SQL FOR SELECTING ALL OF CUSTOMER
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableView.getColumns().removeAll(col);
                tableView.getColumns().addAll(col);

                System.out.println("Column [" +  i + "] ");
            }


       }catch (Exception e){
           System.out.println("Error: " + e.getMessage());
       }
    }



}
