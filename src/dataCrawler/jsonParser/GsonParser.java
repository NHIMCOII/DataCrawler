package dataCrawler.jsonParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.nhanvat.Vua;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GsonParser {
    public static void main(String args[]) throws IOException {
        Vua vua = new Vua("Duy Anh", "Vua", "2002", "2100", null, null, null, null, null);

        // convert book object to JSON
        String json = new Gson().toJson(vua);

        Map<String, Object> map = new HashMap<>();
        map.put("title", "Thinking in Java");
        map.put("isbn", "978-0131872486");
        map.put("year", 1998);
        map.put("authors", new String[]{"Bruce Eckel"});

        // create Gson instance
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // create a writer
        Writer writer = Files.newBufferedWriter(Paths.get("book.json"));

        // convert book object to JSON file
        gson.toJson(map, writer);

        // close writer
        writer.close();
    }
}
