module com.example.module5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.module5 to javafx.fxml;
    exports com.example.module5;
}