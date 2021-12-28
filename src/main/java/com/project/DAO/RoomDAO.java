package com.project.DAO;

import com.project.Controllers.ConnectorController;
import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RoomDAO {
    private ObservableList<ObservableList> data;
    public static List<Room> getrooms() throws SQLException {

        return null;
    }
    //CONNECTION DATABASE
    public void buildData(){
        Connection c ;
        data = FXCollections.observableArrayList();
        try{
          //
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


    // print Data
    public static <T> void displayList(List<T> list) {
        for (T tempUser : list) {
            System.out.println(tempUser);
        }
    }
}
