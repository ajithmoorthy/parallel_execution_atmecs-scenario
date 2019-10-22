package org.atmecs.website.logreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.atmecs.website.constants.FileConstants;
/**
 * logReporter class is used for the implement log 4j
 * and captured the actions which is performed in testscripts 
 * **/
public class LogReporter {
	Logger logger = null;
	/** this method will configure the log4j properties file and crate the object of Logger class
	 * using this object access the logger class method and capture the details of automation
	 * */
	public void logReportMessage(String message) {
		PropertyConfigurator.configure(FileConstants.LOG4J_CONFIG_PROPERTY_PATH);
		logger = Logger.getLogger(LogReporter.class.getName());
		logger.info(message);
	}
}
