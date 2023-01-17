package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.lehoi.LeHoi;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class LeHoiTest {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map m1 = LeHoi.getInfoFromWiki();

        Writer writer = Files.newBufferedWriter(Paths.get("LeHoi.json"));
        gson.toJson(m1, writer);
        writer.close();
    }
}
