package com.project.DAO;

import com.project.Models.Guest;
import com.project.Models.Room;
import com.project.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HibernateController {
    public HibernateController() {
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
        /*
         * ROOM MODEL
         */

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Room("Normal", "Single", 350.0, true));
        session.save(new Room("Normal", "Double", 450.0, false));
        session.save(new Room("Economy", "Single", 400.0, true));
        session.save(new Room("Economy", "Double", 550.0, true));
        session.save(new Room("VIP", "Double", 700.0, false));
        session.getTransaction().commit();

        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<Room> cq1 = session.getCriteriaBuilder().createQuery(Room.class);
        cq1.from(Room.class);
        List<Room> genders1 = session.createQuery(cq1).getResultList();
        System.out.println(genders1.toString());
        //        session.close();

        /*
        * GUEST MODEL
        */

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
        //        session.close();

        /*
         * USER MODEL
         * */

        session.beginTransaction();
        session.save(new User("Jan", "janek233", "jan@example.com", "password", true));
        session.save(new User("Adam", "adas75", "adam@example.com", "password", false));
        session.save(new User("Bartosz", "Bartek00", "bartek00@example.com", "password", false));
        session.save(new User("Anna", "anna093", "anka@example.com", "password", false));
        session.getTransaction().commit();

        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<User> cq2 = session.getCriteriaBuilder().createQuery(User.class);
        cq2.from(User.class);
        List<User> genders2 = session.createQuery(cq2).getResultList();
        System.out.println(genders2.toString());
   }
}
