package app.controller;

import app.search.SearchKey;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BoxDetailController implements Initializable {
    @FXML
    private VBox box;

    @FXML
    private Text title;
    public static String boxContent = "";
    public static String boxTitle = Page3Controller.title;

    public static String key = null;
    public static String value = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setText(Page3Controller.title);
        if (Page3Controller.list != null) {
            for (int i = 0; i < Page3Controller.list.size(); i++) {
                try {
                    boxContent = Page3Controller.list.get(i);
                    box.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Link.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (Page3Controller.map != null) {
            for (Map.Entry<String, String> entry : (Page3Controller.map).entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value);
                box.getChildren().add(new Text("Key: " + key + ", Value: " + value));
            }

        }
    }
}
