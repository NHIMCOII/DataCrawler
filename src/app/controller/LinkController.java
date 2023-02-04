package app.controller;

import app.Main;
import app.search.SearchKey;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.NormalizeTool;
import util.SeperateTool;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LinkController implements Initializable {

    @FXML
    private Text linkText;

    @FXML
    private Button linkBtn;
    public Object linkList = new Object();
    public static String link = "";

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == linkBtn) {
            if (Page3Controller.title.equals("Nhân vật")) {
                SearchKey.result.clear();
                SearchKey.toanPhan(Main.mapNhanVat, NormalizeTool.normalizeKey(link));
                Main.detail = SearchKey.object;
                Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
                Stage window = (Stage) linkBtn.getScene().getWindow();
                window.setScene(new Scene(root));
            }
            if (Page3Controller.title.equals("Nhân vật cùng thời kỳ")) {
                SearchKey.result.clear();
                SearchKey.toanPhan(Main.mapNhanVat, NormalizeTool.normalizeKey(SeperateTool.separateKeyWithoutQuotation(linkText.getText())));
                Main.detail = SearchKey.object;
                Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
                Stage window = (Stage) linkBtn.getScene().getWindow();
                window.setScene(new Scene(root));
            }
            if (Page3Controller.title.equals("Sự kiện")) {
                SearchKey.result.clear();
                SearchKey.toanPhan(Main.mapSuKien, NormalizeTool.normalizeKey(link));
                Main.detail = SearchKey.object;
                Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
                Stage window = (Stage) linkBtn.getScene().getWindow();
                window.setScene(new Scene(root));
            }
            if (Page3Controller.title.equals("Địa điểm")) {
                SearchKey.result.clear();
                SearchKey.toanPhan(Main.mapDiaDiem, NormalizeTool.normalizeKey(link));
                Main.detail = SearchKey.object;
                Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
                Stage window = (Stage) linkBtn.getScene().getWindow();
                window.setScene(new Scene(root));
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        linkText.setText(BoxDetailController.boxContent);
    }

}
