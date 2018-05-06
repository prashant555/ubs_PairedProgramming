package com.src.constant;

/*
 * Constants used throughout the conversion
 * 
 * */
/**
 * @author Prashant
 *
 */
public interface TimeProcessingConstants{
	// Number of lamps
	public static final int NUMBER_OF_HOUR_LAMPS_TOP_TWO_ROWS = 4;
	public static final int NUMBER_OF_MINUTE_LAMPS_IN_LAST_ROW = 4;
	public static final int NUMBER_OF_MINUTE_LAMPS_IN_SECOND_LAST_ROW = 11;
	
	//General constants
	public static final int QUARTER_OF_AN_HOUR = 3;
	public static final int DEFAULT_ZERO = 0;
	public static final int DEFAULT_ONE = 1;
	public static final int DEFAULT_TWO = 2;
	public static final int HOURS_IN_A_DAY = 24;
	public static final int MINUTES_IN_A_HOUR = 60;
	public static final int SECONDS_IN_A_MINUTE = 60;
	public static final int INPUT_TIME_ACTUAL_LENGTH = 8;
	
	//Hours/Minutes/Seconds in Lamp
	public static final int NUMBER_OF_HOURS_OF_TOP_ROW_LAMP = 5;
	public static final int NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_YELLOW_LAMPS = 5;
	public static final int NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_RED_LAMPS = 15;
	public static final int NUMBER_OF_SECONDS_TO_BLINK_YELLOW_LAMP = 2;
	
	//Lamp signals
	public static final String YELLOW_LAMP = "Y";
	public static final String RED_lAMP = "R";
	public static final String NO_LAMP = "O";
	public static final String CARRIAGE_RETURN = "\r\n";
	
	//pattern matcher constants
	public static final String TIME_CONTENT_CONSTANT = "[!-/ ;-~]";
	public static final String TIME_FORMAT_CONSTANT = ".{2}:.{2}:.{2}";
	public static final String COLON = ":";
}