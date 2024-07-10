module com.example.cobasql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cobasql to javafx.fxml;
    exports com.example.cobasql;
}