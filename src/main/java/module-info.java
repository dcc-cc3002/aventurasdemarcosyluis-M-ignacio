module aventurasdemarcoyluis{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;

    exports model;
    opens model to javafx.fxml;
    exports model.items;
    opens model.items to javafx.fxml;
    exports model.factory;
    opens model.factory to javafx.fxml;
    exports model.Hero;
    opens model.Hero to javafx.fxml;
    exports model.Opponent;
    opens model.Opponent to javafx.fxml;

}
