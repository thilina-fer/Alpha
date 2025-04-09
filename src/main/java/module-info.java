module lk.ijse.alpha {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.ijse.alpha to javafx.fxml;
    exports lk.ijse.alpha;
}