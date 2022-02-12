package com.project.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userID;
    @Column(name = "name")
        private String name;
    @Column(name = "login")
        private String login;
    @Column(name = "email")
        private String email;
    @Column(name = "password")
        private String password;
    @Column(name = "is_admin")
        private boolean is_admin;

    public User(String name, String login, String email, String password, boolean is_admin) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }
}
