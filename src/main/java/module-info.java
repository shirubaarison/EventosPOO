module com.grupog.eventospoo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.grupog.eventospoo to javafx.fxml;
    exports com.grupog.eventospoo;
    exports com.grupog.eventospoo.controller;
    opens com.grupog.eventospoo.controller to javafx.fxml;
    exports com.grupog.eventospoo.model;
    opens com.grupog.eventospoo.model to javafx.fxml;
}