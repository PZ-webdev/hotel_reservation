package com.project.DAO;

import com.project.Models.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    Session session = SingletonConnection.getSessionFactory().openSession();

    public List<Room> getRooms() {
        try (Session session = SingletonConnection.getSessionFactory().openSession()) {
            System.out.println("");
            return session.createQuery("from Room", Room.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

}
