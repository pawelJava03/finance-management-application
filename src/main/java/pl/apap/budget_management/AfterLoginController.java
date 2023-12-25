package pl.apap.budget_management;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AfterLoginController {

    @FXML
    public SplitPane mainPane;

    @FXML
    public AnchorPane afterLoginPane, afterLoginPane1;

    @FXML
    public Button button1, button2, button3;

    @FXML
    public TreeTableView table1;


    public void start(){
        LoadFXML loadFXML = new LoadFXML();
        try {
            loadFXML.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
