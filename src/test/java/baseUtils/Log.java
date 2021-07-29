package baseUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Logger logger = LogManager.getLogger();
	
	public static void info(String logMessage) {
		logger.info(logMessage);
	}
	
	public static void error(String logMessage) {
		logger.error(logMessage);
	}
	
	public static void warn(String logMessage) {
		logger.warn(logMessage);
	}
	
	public static void fatal(String logMessage) {
		logger.fatal(logMessage);
	}
	

}
