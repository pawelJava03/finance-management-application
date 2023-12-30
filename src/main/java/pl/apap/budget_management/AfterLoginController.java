package pl.apap.budget_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AfterLoginController {


    @FXML
    private Stage mainStage;
    @FXML
    public SplitPane mainPane;

    @FXML
    public AnchorPane afterLoginPane, afterLoginPane1;

    @FXML
    public Button yoursMoneyButton, investedMoneyButton, earnedMoneyButton, expenseButton, homeButton, logoutButton;

    @FXML
    public Label usernameLabel, appVersionLabel;

    @FXML
    public ImageView topImage;

    DatabaseService dbs = new DatabaseService();



    String email;

    public void start(){
        LoadFXML loadFXML = new LoadFXML();
        try {
            loadFXML.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        dbs.loggedUserInfo(email);


    }
    public void logout(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Logout");
        alert.setContentText("Are you sure you want to log out?");
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

        ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

        if (result == ButtonType.YES) {
            mainStage.close();

            HelloApplication helloApplication = new HelloApplication();
            try {
                helloApplication.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
