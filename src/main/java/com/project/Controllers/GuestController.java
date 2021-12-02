package com.project.Controllers;

import com.project.DAO.SingletonConnection;
import com.project.Models.Guest;
import com.project.Models.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GuestController {
    public GuestController() {
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();

        // Utworzenie nowego obiektu i zapisanie ich do bazy
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Room pokoj1 = session.get(Room.class, 1);
        Room pokoj2 = session.get(Room.class, 2);

        session.save(new Guest(pokoj1, "Jan", "Kowalski", "kowalski@wp.pl", "Cicha 26", "Rzeszów", 156789856, 787897899, 30,360.3));
        session.save(new Guest(pokoj2, "Anna", "Kowalska", "AnkaKowalska@wp.pl", "Glosna 26", "Rzeszów", 336969856, 999897899, 20,260.3));
        session.getTransaction().commit();


        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<Guest> cq = session.getCriteriaBuilder().createQuery(Guest.class);
        cq.from(Guest.class);
        List<Guest> genders = session.createQuery(cq).getResultList();
            System.out.println(genders.toString());
        session.close();
    }
}
