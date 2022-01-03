package com.project.DAO;

import com.project.Models.Guest;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    Session session = SingletonConnection.getSessionFactory().openSession();

    public List<Guest> getGuests() {
        try (Session session = SingletonConnection.getSessionFactory().openSession()) {
            Query<Guest> query = session.createQuery("SELECT c FROM Guest c WHERE date_end >= :now", Guest.class);
//            Query<Guest> query = session.createQuery("From Guest g INNER JOIN Room r where g.id_room = r.id_room", Guest.class);
            query.setParameter("now", LocalDate.now());
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
