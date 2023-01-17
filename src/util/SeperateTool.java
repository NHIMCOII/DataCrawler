package util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SeperateTool extends Tool {
    public static String separateKeyWithoutQuotation(String s) {
        int idx = s.indexOf('(');
        if (idx > 0) {
            return s.substring(0, idx).trim();
        }
        return s;
    }

    public static ArrayList<String> seperateByComma(String str) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(str.split(",")));
        return result;
    }
}
