package util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Tool {
    public static String normalizeKey(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replace("(", "")
                .replace(")", "")
                .replace("đ", "d")
                .replace("Đ", "d").trim().toLowerCase();
    }

    public static String separateKeyWithoutQuotation(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String raw = pattern.matcher(temp).replaceAll("")
                .replace("đ", "d")
                .replace("Đ", "d").trim().toLowerCase();
        int idx = raw.indexOf('(');
        if (idx > 0) {
            return raw.substring(0, idx).trim();
        }
        return raw;
    }

    public static String normalizeKeyThoiKyFromThuVienLichSu(String s) {
        if (s.equals("tu chu")) {
            s = "thoi ky xay nen tu chu";
        }
        if (s.equals("bac thuoc lan 3")) {
            s = "bac thuoc lan iii";
        }
        if (s.equals("nha tien ly - ly nam de")) {
            s = "nha ly \u0026 nha trieu";
        }
        if (s.equals("bac thuoc lan 2 va khoi nghia ba trieu")) {
            s = "bac thuoc lan ii";
        }
        if (s.equals("hai ba trung")) {
            s = "trung nu vuong";
        }
        if (s.equals("khang chien chong my")) {
            s = "viet nam dan chu cong hoa";
        }
        if (s.equals("bac thuoc lan 4")) {
            s = "bac thuoc lan iv";
        }
        return s;
    }

    public static ArrayList<String> seperateByComma(String str) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(str.split(",")));
        return result;
    }
}
