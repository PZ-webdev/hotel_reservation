package com.project.DAO;

import com.project.Models.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    Session session = HibernateConnection.getSessionFactory().openSession();

    public List<Guest> getGuests() {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            System.out.println("");
            return session.createQuery("from Guest", Guest.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void update(Guest selectedGuest) {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(selectedGuest);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
