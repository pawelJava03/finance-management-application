package pl.apap.budget_management;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AfterLoginController {

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
}
