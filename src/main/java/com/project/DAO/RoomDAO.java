package com.project.DAO;

import com.project.Models.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void updateRoom(Room selectedRoom) {
        Transaction transaction = null;
        try (Session session = SingletonConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(selectedRoom);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }
}
