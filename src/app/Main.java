package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Files;

import model.dia_diem.DiTich;
import model.le_hoi.LeHoi;
import model.nhan_vat.Vua;
import model.su_kien.ChienTranh;
import model.thoi_ky.ThoiKy;

import java.nio.file.Paths;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class Main extends Application {
    public static Map<String, Object> mapThoiKy = new LinkedHashMap<>();
    public static Map<String, Object> mapLeHoi = new TreeMap<>();
    public static Map<String, Object> mapNhanVat = new TreeMap<>();
    public static Map<String, Object> mapSuKien = new TreeMap<>();
    public static Map<String, Object> mapDiaDiem = new TreeMap<>();
    public static Object detail;
    public static String tempTitle = "";

    public static void main(String[] args) {
        launch(args);
    }

    public void readFile() {
        String pathThoiKy, pathLeHoi, pathDiaDiem, pathSuKien, pathNhanVat;
        String thoiKy = new File("").getAbsolutePath();
        thoiKy = thoiKy.concat("\\src\\data\\ThoiKy.json");
        String leHoi = new File("").getAbsolutePath();
        leHoi = leHoi.concat("\\src\\data\\LeHoi.json");
        String diaDiem = new File("").getAbsolutePath();
        diaDiem = diaDiem.concat("\\src\\data\\DiaDiem.json");
        String suKien = new File("").getAbsolutePath();
        suKien = suKien.concat("\\src\\data\\SuKien.json");
        String nhanVat = new File("").getAbsolutePath();
        nhanVat = nhanVat.concat("\\src\\data\\NhanVat.json");

        try {
            pathThoiKy = new String(Files.readAllBytes(Paths.get(thoiKy)));
            mapThoiKy = new Gson().fromJson(pathThoiKy,
                    new TypeToken<LinkedHashMap<String, ThoiKy>>() {
                    }.getType());

            pathLeHoi = new String(Files.readAllBytes(Paths.get(leHoi)));
            mapLeHoi = new Gson().fromJson(pathLeHoi, new TypeToken<TreeMap<String, LeHoi>>() {
            }.getType());

            pathDiaDiem = new String(Files.readAllBytes(Paths.get(diaDiem)));
            mapDiaDiem = new Gson().fromJson(pathDiaDiem,
                    new TypeToken<TreeMap<String, DiTich>>() {
                    }.getType());

            pathSuKien = new String(Files.readAllBytes(Paths.get(suKien)));
            mapSuKien = new Gson().fromJson(pathSuKien, new TypeToken<TreeMap<String, ChienTranh>>() {
            }.getType());

            pathNhanVat = new String(Files.readAllBytes(Paths.get(nhanVat)));
            mapNhanVat = new Gson().fromJson(pathNhanVat,
                    new TypeToken<TreeMap<String, Vua>>() {
                    }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        readFile();
        Parent root = FXMLLoader.load(getClass().getResource("./view/Page1.fxml"));
        primaryStage.setScene(new Scene(root, 1800, 850));
        primaryStage.setMaximized(true);
        primaryStage.initStyle(StageStyle.DECORATED);

        //drag it here
//        root.setOnMousePressed(event -> {
//            x = event.getSceneX();
//            y = event.getSceneY();
//        });
//        root.setOnMouseDragged(event -> {
//
//            primaryStage.setX(event.getScreenX() - x);
//            primaryStage.setY(event.getScreenY() - y);
//
//        });
        primaryStage.show();
    }
}
