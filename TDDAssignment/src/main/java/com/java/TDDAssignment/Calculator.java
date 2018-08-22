package com.java.TDDAssignment;

import java.util.Arrays;
import java.util.logging.Logger;

public class Calculator {
private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public int add(String string) {
		String delimeter=",|\n";
		if (string == "") {
			logger.info(""+0);
			return 0;	
		}
		else if (string.startsWith("//")) {
			String[] string1 = string.split("\n");
			string=string1[1];
			 delimeter = string1[0].substring(2);
		}	
		
			String[] stringArray = string.trim().length() < 1 ? new String[0] : string.split(delimeter);
			int sum = Arrays.stream(stringArray).map(x -> Integer.parseInt(x)).filter(x -> x <= 1000).reduce(Integer::sum).get();
			logger.info(""+sum);
			return sum;
		
		}
		
		
	}
