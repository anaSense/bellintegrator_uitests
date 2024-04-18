package helpers;

public class StringsHelper {

    public static String[] divideStringBySeparator(String str, String separator) {
        str = str.replace(" ", "");
        return str.split(separator);
    }
}
