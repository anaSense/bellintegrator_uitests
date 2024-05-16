package helpers;


import java.io.*;
import java.util.Properties;

public class PropertyReader {

    public static Properties constantsProperties = new Properties();

    public static void readPropertyFile(String filepath) {
        try (InputStream is = PropertyReader.class.getClassLoader().getResourceAsStream(filepath);
             Reader reader = new InputStreamReader(is, "UTF-8")) {
            if (reader == null) {
                System.out.println("Sorry, unable to find testData.properties");
                return;
            }
            constantsProperties.load(reader);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
