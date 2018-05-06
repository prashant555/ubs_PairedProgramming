package com.src.utils;

import static com.src.constant.TimeProcessingConstants.COLON;
import static com.src.constant.TimeProcessingConstants.DEFAULT_ONE;
import static com.src.constant.TimeProcessingConstants.DEFAULT_TWO;
import static com.src.constant.TimeProcessingConstants.DEFAULT_ZERO;
import static com.src.constant.TimeProcessingConstants.HOURS_IN_A_DAY;
import static com.src.constant.TimeProcessingConstants.INPUT_TIME_ACTUAL_LENGTH;
import static com.src.constant.TimeProcessingConstants.MINUTES_IN_A_HOUR;
import static com.src.constant.TimeProcessingConstants.SECONDS_IN_A_MINUTE;
import static com.src.constant.TimeProcessingConstants.TIME_CONTENT_CONSTANT;
import static com.src.constant.TimeProcessingConstants.TIME_FORMAT_CONSTANT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.src.exception.TimeConverterException;

/*
 * Responsible to validate the format, content and range of the input time before conversion
 * 
 * */
/**
 * @author Prashant
 *
 */
public class TimeConverterValidatorUtil {
	/*
	 * performs the content based validation
	 * 
	 * */
	public static void timeContentValidator(String aTime) throws TimeConverterException{
		
		Pattern regex = Pattern.compile(TIME_CONTENT_CONSTANT);
		Matcher matcher = regex.matcher(aTime);
		
		if(matcher.find()){
			
			throw new TimeConverterException("Entered time content is invalid.It contains either alphabet or some special characters.");
		}
		
	}
	
	/*
	 * performs the range based validation
	 * 
	 * */
	public static void timeRangeValidater(String aTime) throws TimeConverterException{
		
		String timeComponent[] = aTime.split(COLON);
		
		int hour = Integer.parseInt(timeComponent[DEFAULT_ZERO]), minute = Integer.parseInt(timeComponent[DEFAULT_ONE]), second = Integer.parseInt(timeComponent[DEFAULT_TWO]);
		
		if (hour < DEFAULT_ZERO || hour > HOURS_IN_A_DAY
				|| minute < DEFAULT_ZERO || minute > MINUTES_IN_A_HOUR
				|| second < DEFAULT_ZERO || second > SECONDS_IN_A_MINUTE) {
			
			throw new TimeConverterException("Either hour or minute or second is/are not as per time range.");
		}
		
		if(hour == HOURS_IN_A_DAY && (minute > DEFAULT_ZERO || second > DEFAULT_ZERO)){
			
			throw new TimeConverterException("Either minute or second is/are not as per time range.");
		}
		
	}
	
	/*
	 * performs the format and length based validation
	 * 
	 * */
	public static void timeFormatValidator(String aTime) throws TimeConverterException{
		
		Pattern regex = Pattern.compile(TIME_FORMAT_CONSTANT);
		Matcher matcher = regex.matcher(aTime);
		
		if(!matcher.find() || aTime.length() != INPUT_TIME_ACTUAL_LENGTH){
			
			throw new TimeConverterException("Entered time format is invalid.");
		}
		
	}
}