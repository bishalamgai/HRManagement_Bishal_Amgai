module com.example.hrmanagement_bishal_amgai {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.hrmanagement_bishal_amgai to javafx.fxml;
    exports com.example.hrmanagement_bishal_amgai;
}