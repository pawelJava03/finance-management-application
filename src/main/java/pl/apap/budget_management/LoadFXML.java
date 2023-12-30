package pl.apap.budget_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadFXML extends Application {
    String fileName = "main-page.fxml";

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
        Parent root = loader.load();

        AfterLoginController controller = loader.getController();
        controller.setMainStage(primaryStage);

        primaryStage.setTitle("Budget Management");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
