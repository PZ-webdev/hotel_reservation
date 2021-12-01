module com.project {
    requires javafx.fxml;
    requires javafx.controls;

    requires java.sql;
    requires java.persistence;
    requires java.naming;

    requires org.hibernate.orm.core;
    opens com.project to javafx.fxml;

    exports com.project;
    exports com.project.Controllers;
    exports com.project.Models;
    exports com.project.DAO;

    opens com.project.Models;
}