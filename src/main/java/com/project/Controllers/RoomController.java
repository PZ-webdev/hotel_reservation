package com.project.Controllers;

import com.project.DAO.SingletonConnection;
import com.project.Models.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RoomController {
    public RoomController() {
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();

        // Utworzenie nowego obiektu i zapisanie ich do bazy
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Room("Normal", "Single", 350.0, true));
        session.save(new Room("Normal", "Double", 450.0, false));
        session.save(new Room("Economy", "Single", 400.0, true));
        session.save(new Room("Economy", "Double", 550.0, true));
        session.save(new Room("VIP", "Double", 700.0, false));
        session.getTransaction().commit();


        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<Room> cq = session.getCriteriaBuilder().createQuery(Room.class);
        cq.from(Room.class);
        List<Room> genders = session.createQuery(cq).getResultList();
            System.out.println(genders.toString());
        session.close();
    }
}
