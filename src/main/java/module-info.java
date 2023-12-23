module pl.apap.budget_management {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens pl.apap.budget_management to javafx.fxml;
    exports pl.apap.budget_management;
}