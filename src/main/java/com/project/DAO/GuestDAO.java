package com.project.DAO;

import com.project.Models.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    Session session = HibernateConnection.getSessionFactory().openSession();

    /**
     *  Pobranie listy gości z bazdy danych z użyciem Hibernate'a
     * */
    public List<Guest> getGuests() { // TODO: Add relation query
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            Query<Guest> query = session.createQuery("SELECT c FROM Guest c WHERE date_end >= :now", Guest.class);
            query.setParameter("now", LocalDate.now());
            System.out.println(query.getResultList().get(0).getRoomID().getRoom_type());
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     *  Utworzenie gości z bazdy danych z użyciem Hibernate'a
     * */
    public boolean create(Guest guest) {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(guest);
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
