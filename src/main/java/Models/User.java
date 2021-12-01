package Models;

import javax.persistence.*;

@Entity
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

    public User() {
    }

    public User(String name, String login, String email, String password, boolean is_admin) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
