package pl.apap.budget_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {


    @FXML
    public SplitPane loginPane;
    @FXML
    public AnchorPane loginPane1, loginPane2, afterLoginPane, afterLoginPane1;
    @FXML
    public TextField emailField, registerName, registerSurname, registerEmail;

    @FXML
    public PasswordField passwordField, registerPassword, registerPassword2;

    @FXML
    public Button loginButton;

    @FXML
    public Button registerButton;
    AfterLoginController afterLoginController = new AfterLoginController();
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
                afterLoginController.start();
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

        String name = registerName.getText();
        String surname = registerSurname.getText();
        String email = registerEmail.getText();
        String password = registerPassword.getText();
        String passwrod2 = registerPassword2.getText();

        alert.setTitle("REGISTER ERROR");
        if(dbs.userExists(email)){
            alert.setContentText("Account with that email already exists");
            alert.showAndWait();
        } else if (name.isBlank()|| name.isEmpty()) {
            alert.setContentText("Please enter your name");
            alert.showAndWait();
        } else if (surname.isBlank()|| surname.isEmpty()) {
            alert.setContentText("Please enter your surname");
            alert.showAndWait();
        }else if(email.isBlank()|| email.isEmpty()) {
            alert.setContentText("Please enter your email");
            alert.showAndWait();
        }else if(!password.equals(passwrod2)) {
            alert.setContentText("Passwords are not the same.");
            alert.showAndWait();
        }else {
            dbs.newUser(name, surname, email, password);
            alert.setTitle("Account created");
            alert.setContentText("Account created successfully. Now you can login");
            alert.showAndWait();
        }
    }


}
