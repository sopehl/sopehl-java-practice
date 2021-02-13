package com.sopehl.log4j;

import org.apache.log4j.Logger;

public class Log4JDemo {
	
	private final static Logger LOGGER = Logger.getLogger(Log4JDemo.class);
	
	private final static Boolean TEST_LOG4J_BACKUP = Boolean.FALSE;

	public static void main(String[] args) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("My debug log");
		}
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("My info log");
		}
		
		String errorMessage = "this is your error";
		LOGGER.error("My error log message : " + errorMessage);
		LOGGER.error("My error log exception : " + new RuntimeException("This is Runtime Exception"));
		
		LOGGER.warn("My warn log");
		LOGGER.fatal("My fatal log");
		
		try {
			int i = 34 / 0;
			System.out.println("Result: " + i);
		}catch (ArithmeticException e) {
			LOGGER.error("division by zero error : ", e);
		}
		
		if(TEST_LOG4J_BACKUP) {
			for(int i = 0; i < 16000; i++) {
				if(LOGGER.isDebugEnabled()) {
					LOGGER.debug("512bitSecretKey!512bitSecretKey!512bitSecretKey!512bitSecretKey!");
				}
			}	
		}
		
		System.out.println("--------- End of Program ---------");
	}
	
}
