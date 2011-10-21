package se.glassfish.asadmin.api.util;

public class StringUtil {

    public static String escape(String value, String chars) {
        return escape(value, chars, "\\\\");
    }

    public static String escape(String value, String chars, String escapeSequence) {
        String escaped = value;
        if (escaped == null) {
            return "";
        }
        for (char ch : chars.toCharArray()) {
            escaped = escaped.replaceAll(String.valueOf(ch), escapeSequence + ch);
        }
        return escaped;
    }

}
