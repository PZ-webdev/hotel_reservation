package com.project.Controllers;

import com.project.DAO.SingletonConnection;
import com.project.Models.Guest;
import com.project.Models.Room;
import com.project.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class HibernateController {
    public HibernateController() {}

   public void addDataToDatabase() throws ParseException {
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

       session.save(new Guest(pokoj1, "Jan Kowalski", "kowal@wp.pl", 666999888, LocalDate.now(), LocalDate.now().plusDays(2), 150.0));
       session.save(new Guest(pokoj2, "Anna Wróbel", "wroble@gmail.com", 558887987, LocalDate.now(), LocalDate.now().plusDays(3), 250.0));
       session.save(new Guest(pokoj2, "Kamil Kowal", "kowal@gmail.com", 558887987, LocalDate.now().minusDays(4), LocalDate.now().minusDays(2),250.0));
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
