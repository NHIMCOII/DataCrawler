package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoxDetailController implements Initializable {
    @FXML
    private VBox box;

    @FXML
    private Text title;
    public static String boxContent = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setText(Page3Controller.title);

        for (int i = 0; i < Page3Controller.list.size(); i++) {
            try {
                boxContent = Page3Controller.list.get(i);
                box.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Link.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
