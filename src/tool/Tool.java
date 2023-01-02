package tool;

import java.text.Normalizer;
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
}
