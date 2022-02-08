module com.project {
//    requires javafx.fxml;
//    requires javafx.controls;
//
//    requires java.sql;
//    requires java.persistence;
//    requires java.naming;
//
//    requires org.hibernate.orm.core;
//    requires lombok;
//    opens com.project to javafx.fxml;
//
//    exports com.project;
//    exports com.project.Controllers;
//    exports com.project.Models;
//    exports com.project.DAO;
//
//    opens com.project.Models;
//    opens com.project.Controllers to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires lombok;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    exports com.project.Models;
    exports com.project.DAO;
    exports com.project.Controllers;
    opens com.project.Models;

    opens com.project to javafx.fxml;
    exports com.project;
}