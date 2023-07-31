module com.example.mfsum {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires java.logging;
    requires java.sql;

    opens com.example.mfsum to javafx.fxml;
    exports com.example.mfsum;
    exports com.example.mfsum.ui;
    opens com.example.mfsum.ui to javafx.fxml;
    opens com.example.mfsum.business.sqlConnection to javafx.graphics;
    exports com.example.mfsum.business.sqlConnection to javafx.graphics;
}