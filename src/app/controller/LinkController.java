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
import model.nhan_vat.NhanVat;
import util.NormalizeTool;
import util.SeperateTool;

import java.net.URL;
import java.util.ResourceBundle;

public class LinkController implements Initializable {

    public static String link = "";
    public Object linkList = new Object();
    @FXML
    private Text linkText;
    @FXML
    private Button linkBtn;
    private String linkTitle = "";

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public void handleBtnLink(ActionEvent event) throws Exception {
        if (event.getSource() == linkBtn) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
            Stage window = (Stage) linkBtn.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        linkText.setText(BoxDetailController.boxContent);
        if (this.linkTitle.equals("Nhân vật")) {
            Page3Controller.details = SearchKey.toanPhan(Main.mapNhanVat, NormalizeTool.normalizeKey(SeperateTool.separateKeyWithoutQuotation(linkText.getText().toString())));
//            linkText.setText(((NhanVat) Page3Controller.details).getTen());
        }
        if (this.linkTitle.equals("Nhân vật cùng thời kỳ")) {
            Page3Controller.details = SearchKey.toanPhan(Main.mapNhanVat, NormalizeTool.normalizeKey(SeperateTool.separateKeyWithoutQuotation(linkText.getText().toString())));
        }
        if (this.linkTitle.equals("Sự kiện")) {
            Page3Controller.details = SearchKey.toanPhan(Main.mapSuKien, NormalizeTool.normalizeKey(SeperateTool.separateKeyWithoutQuotation(linkText.getText().toString())));

        }
        if (this.linkTitle.equals("Địa điểm")) {
            Page3Controller.details = SearchKey.toanPhan(Main.mapDiaDiem, NormalizeTool.normalizeKey(SeperateTool.separateKeyWithoutQuotation(linkText.getText().toString())));
        }
    }

}
