package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.nio.file.Files;
import util.SeperateTool;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiaDiem;
import util.NormalizeTool;


public class Main extends Application {

    private double x, y;
    public static List<DiaDiem> output = new ArrayList<>();
    public static ArrayList<DiaDiem> view = new ArrayList<>();
    public static void searchDiaDiem(String key) {


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String diaDiem = new File("").getAbsolutePath();
        System.out.println(diaDiem);
        diaDiem = diaDiem.concat("\\src\\data\\DiaDiem.json");
        System.out.println("nnnnnn");
        try {
            result = new String(Files.readAllBytes(Paths.get(diaDiem)));
            System.out.println("nnnnnn");
            Map<String, DiaDiem> mapDiaDiem = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiaDiem>>() {
            }.getType());

            // view all
            for (Entry<String, DiaDiem> diaDiemEntry : mapDiaDiem.entrySet()) {
                String keyEntry = diaDiemEntry.getKey();
                DiaDiem valueEntry = diaDiemEntry.getValue();
                view.add(valueEntry);
            }

            String search;
            if (key.contains("(")) {
                String KeyWithoutQuotation = SeperateTool.separateKeyWithoutQuotation(key);
                search = NormalizeTool.normalizeKey(KeyWithoutQuotation);
//			} else if (key.contains("-")) {
//				String KeyWithoutHyphen = SeperateTool.separateKeyWithoutHyphen(key);
//				search = NormalizeTool.normalizeKey(KeyWithoutHyphen);
            } else {
                search = NormalizeTool.normalizeKey(key);
            }

            // tìm kiếm toàn phần
            if (mapDiaDiem.containsKey(search)) {
                DiaDiem tk = (DiaDiem) mapDiaDiem.get(search);
                output.add(tk);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./view/Page1.fxml"));
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.DECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
