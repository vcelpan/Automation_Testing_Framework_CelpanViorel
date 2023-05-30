package Common.managers;

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
        String PROPERTY_FILE_PATH = "AutomationTestingFramework/src/main/resources/config.properties";
        try {
            properties.load(new FileReader(PROPERTY_FILE_PATH));
            logger.info("config.properties file successfully found!");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            throw new RuntimeException("config.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getProperty(String key){
        if (properties == null)
            initializeProperties();
        String value = properties.getProperty(key);
        if (value != null) {
            logger.info(String.format("The '%s' specified in config.properties file: %s", key, value));
            return value;
        }
        else {
            String message = String.format("Unable to locate %s within config.properties file", key);
            logger.error(message);
            throw new RuntimeException(message);
        }
    }
}
