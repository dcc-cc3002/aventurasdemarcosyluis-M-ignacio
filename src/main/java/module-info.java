module com.example.aventurasdemarcoyluis{
    requires javafx.controls;
    requires javafx.fxml;

    exports model;
    opens model to javafx.fxml;
    exports model.abstracts;
    opens model.abstracts to javafx.fxml;
    exports model.enums;
    opens model.enums to javafx.fxml;
    exports model.items;
    opens model.items to javafx.fxml;
    exports model.interfaces;
    opens model.interfaces to javafx.fxml;
}