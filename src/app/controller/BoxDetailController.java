package app.controller;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class BoxDetailController implements Initializable {
    @FXML
    private VBox box;

    @FXML
    private Text title;
    public static String boxContent = "";
    public static String boxTitle = "";

    public static String key = null;
    public static String value = null;
    public String titleTrieudai = null;
    Text text = new Text();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setText(Page3Controller.title);
        if (Page3Controller.list != null) {
            if (Page3Controller.title.equals("Links") || Page3Controller.title.equals("Vợ") || Page3Controller.title.equals("Hậu duệ") || Page3Controller.title.equals("Lịch sử") || Page3Controller.title.equals("Mô tả") || Page3Controller.title.equals("Diễn biến") || Page3Controller.title.equals("Thông tin")) {
                for (String listText : Page3Controller.list) {
                    text = new Text(listText);
                    box.getChildren().add(text);
                }
            } else {
                for (int i = 0; i < Page3Controller.list.size(); i++) {
                    try {
                        boxContent = Page3Controller.list.get(i);
                        LinkController link = new LinkController();
                        link.setLinkTitle(title.getText());
                        box.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Link.fxml")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        if (Page3Controller.map != null) {
            for (Map.Entry<String, String> entry : (Page3Controller.map).entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                box.getChildren().add(new Text(key + ": " + value));
            }
        }
        if (Page3Controller.listTrieuDai != null) {
            for (int i = 0; i < Page3Controller.listTrieuDai.size(); i++) {
                box.getChildren().add(new Text("- " + Page3Controller.listTrieuDai.get(i).getTen() + ": "));
                text = new Text("  Mô tả: " + Page3Controller.listTrieuDai.get(i).getMoTa());
                box.getChildren().add(text);
                box.getChildren().add(new Text("  Link: " + Page3Controller.listTrieuDai.get(i).getLinks() + "\n"));
            }
        }
        text.setWrappingWidth(1400);
    }
}
