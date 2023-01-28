package util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class NormalizeTool extends Tool {
    public static String normalizeKey(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replace("đ", "d")
                .replace("Đ", "d").trim().toLowerCase();
    }

    public static String normalizeKeyThoiKyFromThuVienLichSu(String s) {
        if (s.equals("tu chu")== true) {
            s = "thoi ky xay nen tu chu";
        }
        else if (s.equals("bac thuoc lan 3")== true) {
            s = "bac thuoc lan iii";
        }
        else if (s.equals("nha tien ly - ly nam de")== true) {
            s = "nha ly \u0026 nha trieu";
        }
        else if (s.equals("bac thuoc lan 2 va khoi nghia ba trieu")== true) {
            s = "bac thuoc lan ii";
        }
        else if (s.equals("hai ba trung")== true) {
            s = "trung nu vuong";
        }
        else if (s.equals("khang chien chong my")== true) {
            s = "viet nam dan chu cong hoa";
        }
        else if (s.equals("bac thuoc lan 4")== true) {
            s = "bac thuoc lan iv";
        }
        return s;
    }
}
