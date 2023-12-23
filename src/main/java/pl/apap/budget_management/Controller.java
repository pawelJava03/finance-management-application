package pl.apap.budget_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button loginButton;

    @FXML
    public Button registerButton;
    DatabaseService dbs = new DatabaseService();

    public void login(ActionEvent event) {

        String email = emailField.getText();
        String password = passwordField.getText();

        boolean isValid = dbs.checkUser(email, password);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        if (dbs.userExists(email)) {
            if(isValid){
                alert.setContentText("logged in");
                // metoda to drugiego widoku.
                emailField.setVisible(false);
            } else {
                alert.setContentText("Wrong password");
            }
        } else {
            alert.setContentText("User does not exist. Please create a free account");
        }
        alert.showAndWait();
    }


    public void register(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Register");
        alert.setHeaderText(null);
        alert.setContentText("Przycisk rejestracji został naciśnięty!");

        alert.showAndWait();
    }
}
