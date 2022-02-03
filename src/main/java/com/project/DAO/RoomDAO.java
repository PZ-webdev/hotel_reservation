package com.project.DAO;

import com.project.Models.Room;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    Session session = HibernateConnection.getSessionFactory().openSession();

    /**
     *  Pobranie listy pokojów z bazdy danych z użyciem Hibernate'a
     *
     * @return  liste pokojów
     * */
    public List<Room> getRooms() {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            System.out.println("");
            return session.createQuery("from Room", Room.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     *  Edycja pokojów z bazdy danych z użyciem Hibernate'a
     *
     * @param selectedRoom
     * */
    public void updateRoom(Room selectedRoom) {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
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

    /**
     *  Usuwanie pokoju z bazdy danych z użyciem Hibernate'a
     *
     * @param room
     * */
    public void delete(Room room) {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(room);
            transaction.commit();
        } catch (Exception ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nie można usunąć danego pokoju, ponieważ jest w użyciu..");
            alert.showAndWait();

            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    /**
     *  Utowrzenie nowego pokoju z użyciem Hibernate'a
     *
     * @param room
     * @return boolean, czy poprawnie dodano dane do bazy
     * */
    public boolean create(Room room) {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(room);
            transaction.commit();
            return transaction.getStatus() == TransactionStatus.COMMITTED;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return false;
    }

}
