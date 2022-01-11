package com.project.DAO;

import com.project.Models.Guest;
import org.hibernate.Session;

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
}
