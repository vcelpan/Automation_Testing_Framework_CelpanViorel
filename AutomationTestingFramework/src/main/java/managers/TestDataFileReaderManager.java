package managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataFileReaderManager {
    private static Properties properties;

    public static void initializeProperties() {
        properties = new Properties();
        String PROPERTY_FILE_PATH = "src/main/resources/config.properties";
        try {
            properties.load(new FileReader(PROPERTY_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getApplicationUrl() {
        if (properties == null)
            initializeProperties();
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else {
            String message = "Application Url is not specified in the test.properties file for the Key:url";
            LoggerManager.logConfig(message);
            throw new RuntimeException(message);
        }
    }

    public static String getBrowserType() {
        if (properties == null)
            initializeProperties();
        String browserType = properties.getProperty("browserType");
        if (browserType != null)
            return browserType;
        else {
            String message = "The Browser type is not specified in the test.properties file for the Key:browserType";
            LoggerManager.logConfig(message);
            throw new RuntimeException(message);
        }
    }

}
