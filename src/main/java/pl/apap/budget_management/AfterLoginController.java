package pl.apap.budget_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    public Label usernameLabel, appVersionLabel, moneyLabel;

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

    public void yoursMoneyButton(ActionEvent e){
        String fileName = "YoursMoney.fxml";
        loadAndSetPane(fileName);

    }
    public void investedMoneyButton(ActionEvent e){
        String fileName = "InvestedMoney.fxml";
        loadAndSetPane(fileName);
    }
    public void earnedMoneybutton(ActionEvent e){
        String fileName = "EarnedMoney.fxml";
        loadAndSetPane(fileName);
    }
    public void expenseButton(ActionEvent e){
        String fileName = "Expenses.fxml";
        loadAndSetPane(fileName);

        int expenses=0;
        int totalSpentedMoney=0;

    }


    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void loadAndSetPane(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            AnchorPane newPane = loader.load();

            // Zamień zawartość mainPane na nowy AnchorPane
            mainPane.getItems().set(1, newPane); // Zakładam, że mainPane ma dwa elementy, a nowy AnchorPane będzie na pozycji 1.

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd ładowania pliku FXML.");
        }
    }
}
