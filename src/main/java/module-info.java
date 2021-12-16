module aventurasdemarcoyluis{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;

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
    exports model.factory;
    opens model.factory to javafx.fxml;

}
