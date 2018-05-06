package com.ubs.src.timeConverterImpl;

import static com.src.utils.TimeConverterValidatorUtil.timeContentValidator;
import static com.src.utils.TimeConverterValidatorUtil.timeFormatValidator;
import static com.src.utils.TimeConverterValidatorUtil.timeRangeValidater;
import com.src.exception.TimeConverterException;
import com.src.utils.TimeConverterUtil;

/**
 * @author Prashant
 *
 */
public class TimeConverterImpl implements TimeConverter {
	/*
	 * Converts the time into Berlin clock format
	 * 
	 * */
	@Override
	public String convertTime(String aTime) {
		// Creates the Berlin clock place holder
		StringBuilder berlinClock = new StringBuilder();
		String[] timeComponent = null;
		try{
			// validates the time format
		    timeValidator(aTime);
		    // Splits the time into components in order to process
			timeComponent = aTime.split(COLON);
			
			TimeConverterUtil converterUtil = new TimeConverterUtil();
			
			// Converts the time into berlin clock format
			converterUtil.berlinClockSecondRepresentation(Integer.parseInt(timeComponent[DEFAULT_TWO]), berlinClock);
			converterUtil.berlinClockHourRepresentation(Integer.parseInt(timeComponent[DEFAULT_ZERO]), berlinClock);
			converterUtil.berlinClockMinuteRepresentation(Integer.parseInt(timeComponent[DEFAULT_ONE]), berlinClock);
		}catch(TimeConverterException converterException){
			// initialize it with the exception thrown by the validator
			if(berlinClock.length() == DEFAULT_ZERO){
				berlinClock.append(converterException.getMessage());
			}
		}
		
		return berlinClock.toString();
	}
	
	/*
	 * Calls the validator framework in order to perform time format based validation
	 * 
	 * */
	private void timeValidator(String aTime) throws TimeConverterException{
		timeContentValidator(aTime);
		timeFormatValidator(aTime);
		timeRangeValidater(aTime);
	}
}