package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.nhanvat.ChuTichNuoc;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.thoiKy.ThoiKy;
import dataCrawler.links.Nhanvat_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;

public class NhanVatTest {
    public static void main(String[] args) throws IOException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = NhanVat.getInfoFromThuVienLichSu(Nhanvat_Links.getNhanVat_thuvienlichsu());
            Map m2 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
            Map m3 = NhanVat.getInfoFromNguoiKeSu(Nhanvat_Links.getNhanVat_nguoikesu());
            Map m4 = ChuTichNuoc.getInfoFromWiki(Nhanvat_Links.getChuTichNuoc_wiki());
//            // m2 or newVal must e instance of m1
            m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return Vua.mergeRule(oldVal, newVal);
            }));

            m3.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return NhanVat.mergeRule(oldVal, newVal);
            }));

            m4.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return ChuTichNuoc.mergeRule(oldVal, newVal);
            }));

            Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
            gson.toJson(m1, writer);
            writer.close();
            
            
            String result;
            String nhanvat = "C:\\Users\\LENOVO\\eclipse-workspace\\DataCrawler\\src\\data\\NhanVat.json";
            result = new String(Files.readAllBytes(Paths.get(nhanvat)));
            
            Map<String, Object> map = new Gson().fromJson(result, new TypeToken<TreeMap<String, ThoiKy>>(){}.getType());
            
            if(map.containsKey("bac thuoc lan ii")) {
            	ThoiKy r = (ThoiKy) map.get("bac thuoc lan ii");
            	System.out.println(r.getMoTa());
            }
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        
        
    }
}
