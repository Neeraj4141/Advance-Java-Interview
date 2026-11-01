package com.neeraj.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {

	static Logger log = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {

		log.debug("This is Debug...!!");
		log.info("This is Info...!!");
		log.warn("This is Warn...!!");
		log.error("This is Error...!!");
		log.fatal("This is Fatal...!!");

		try {
			int i = 0;
			int c = 5 / i;

			System.out.println("Division = " + c);

		} catch (RuntimeException e) {
			log.error("Arithmetic Error", e);
		}
	}
	
	/*
	 * log4j.rootLogger=info, file, stdout
	 * 
	 * # Direct log messages to a log file
	 * log4j.appender.file=org.apache.log4j.RollingFileAppender
	 * log4j.appender.file.File=C:\\log4j\\app.log
	 * log4j.appender.file.MaxFileSize=10MB
	 * log4j.appender.file.layout=org.apache.log4j.PatternLayout
	 * log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p
	 * %C{1}:%L - %m%n
	 * 
	 * # Direct log messages to stdout
	 * log4j.appender.stdout=org.apache.log4j.ConsoleAppender
	 * log4j.appender.stdout.Target=System.out
	 * log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
	 * log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p
	 * %C{1}:%L - %m%n
	 */
}