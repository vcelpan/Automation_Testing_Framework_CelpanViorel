package managers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerManager {

    public static Logger logger;

    public static void initLogger() {
        logger = logger.getLogger(LoggerManager.class.getName());
    }

    public static void logInfo(String message) {
        if (logger == null) initLogger();
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        if (logger == null) initLogger();
        logger.log(Level.WARNING, message);
    }

    public static void logConfig(String message) {
        if (logger == null) initLogger();
        logger.log(Level.CONFIG, message);
    }
}
