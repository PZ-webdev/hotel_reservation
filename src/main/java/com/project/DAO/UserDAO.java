package com.project.DAO;

import com.project.Models.User;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDAO {

    /**
     *  Pobranie użytkownika któray się loguje do aplikacji  z użyciem Hibernate'a
     *
     * @param userName login uzytkownika
     * @param password hasło użytkownika
     * @return sprawdzenie czy podany uzytkownik istnieje
     * */
    public static User getConnectedUser(String userName, String password) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            TypedQuery<User> query = session.createQuery("SELECT u FROM User u WHERE login = :login AND password = :password", User.class );
            query.setParameter("login", userName);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            System.err.println("User not found");
            return null;
        }
    }

}
