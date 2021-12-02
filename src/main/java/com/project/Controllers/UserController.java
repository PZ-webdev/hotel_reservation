package com.project.Controllers;

import com.project.DAO.SingletonConnection;
import com.project.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserController {
    public UserController() {
        SessionFactory sessionFactory = SingletonConnection.getSessionFactory();

        // Utworzenie nowego obiektu i zapisanie ich do bazy
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new User("Jan", "janek233", "jan@example.com", "password", true));
        session.save(new User("Adam", "adas75", "adam@example.com", "password", false));
        session.save(new User("Bartosz", "Bartek00", "bartek00@example.com", "password", false));
        session.save(new User("Anna", "anna093", "anka@example.com", "password", false));
        session.getTransaction().commit();

        // Pobranie wszystkich obiektów danej klasy z bazy danych
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        cq.from(User.class);
        List<User> genders = session.createQuery(cq).getResultList();
        System.out.println(genders.toString());
        session.close();
    }
}
