/*
 * Copyright (�) 2012 The Johns Hopkins University Applied Physics Laboratory.
 * All Rights Reserved.  
 */
package org.rapidandroid;

import org.apache.log4j.Logger;

import de.mindpipe.android.logging.log4j.LogConfigurator;
/**
 * SOURCE: http://muratonnet.com/index.php/2012/02/29/use-log4j-in-android/
 * @author Murat Aras
 * 
 * Example Usage:
 		Logger mLog = Logger.getLogger(RapidAndroidApplication.class);

 		// write some logs
		mLog.error("This is an error");
		mLog.info("This is an info");
		mLog.warn("This is a warn");
		 
		// write some exception
		try {
		    String dummyString = null;
		    if (dummyString.equals("something")) {
		        int dummyInt = 1;
		    }
		} catch (Exception ex) {
		    mLog.error(ex.toString(), ex);
		}
		
		String replytxt = ApplicationGlobals.getParseInProgressText();
		mLog.info("reply text = " + replytxt);
 *
 */
public class Log4jHelper {
	 
    private final static LogConfigurator _logConfigurator = new LogConfigurator();
 
    public static void Configure(String fileName, String filePattern,
            int maxBackupSize, long maxFileSize) {
 
        // set the name of the log file
        _logConfigurator.setFileName(fileName);
        // set output format of the log line
        _logConfigurator.setFilePattern(filePattern);
        // Maximum number of backed up log files
        _logConfigurator.setMaxBackupSize(maxBackupSize);
        // Maximum size of log file until rolling
        _logConfigurator.setMaxFileSize(maxFileSize);
        // Use LogCat appender
        _logConfigurator.setUseLogCatAppender(true);
        
        // configure
        _logConfigurator.configure();
 
    }
 
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        return logger;
    }
 
}