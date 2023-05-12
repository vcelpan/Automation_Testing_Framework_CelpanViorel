package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataFileReaderManager {
    private static Properties properties;

    private static final Logger logger = LogManager.getLogger(TestDataFileReaderManager.class);

    public static void initializeProperties() {
        properties = new Properties();
        String PROPERTY_FILE_PATH = "src/main/resources/config.properties";
        try {
            properties.load(new FileReader(PROPERTY_FILE_PATH));
            logger.info("config.properties file successfully found!");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            throw new RuntimeException("config.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getApplicationUrl() {
        if (properties == null)
            initializeProperties();
        String url = properties.getProperty("url");
        if (url != null) {
            logger.info("The url specified in config.properties: " + url);
            return url;
        }
        else {
            String message = "Application Url is not specified in the config.properties file for the Key:url";
            logger.error(message);
            throw new RuntimeException(message);
        }
    }

    public static String getBrowserType() {
        if (properties == null)
            initializeProperties();
        String browserType = properties.getProperty("browserType");
        if (browserType != null){
            logger.info("The browser type specified in config.properties: " + browserType);
            return browserType;
        }
        else {
            String message = "The Browser type is not specified in the config.properties file for the Key:browserType";
            logger.error(message);
            throw new RuntimeException(message);
        }
    }

}
