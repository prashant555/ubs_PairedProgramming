package com.src.utils;

import static com.src.constant.TimeProcessingConstants.CARRIAGE_RETURN;
import static com.src.constant.TimeProcessingConstants.DEFAULT_ONE;
import static com.src.constant.TimeProcessingConstants.DEFAULT_ZERO;
import static com.src.constant.TimeProcessingConstants.NO_LAMP;
import static com.src.constant.TimeProcessingConstants.NUMBER_OF_HOURS_OF_TOP_ROW_LAMP;
import static com.src.constant.TimeProcessingConstants.NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_RED_LAMPS;
import static com.src.constant.TimeProcessingConstants.NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_YELLOW_LAMPS;
import static com.src.constant.TimeProcessingConstants.NUMBER_OF_SECONDS_TO_BLINK_YELLOW_LAMP;
import static com.src.constant.TimeProcessingConstants.QUARTER_OF_AN_HOUR;
import static com.src.constant.TimeProcessingConstants.RED_lAMP;
import static com.src.constant.TimeProcessingConstants.YELLOW_LAMP;
import com.src.constant.TimeProcessingConstants;
import com.src.constant.TimeType;

/*
 * Responsible to convert the time into berlin representation
 * 
 * */
/**
 * @author Prashant
 *
 */
public class TimeConverterUtil {
	/*
	 * performs the conversion of seconds into equivalent berlin seconds representation
	 * 
	 * */
	public void berlinClockSecondRepresentation(int aSecondTime, StringBuilder aBerlinClockBuilder){ 
		if(aSecondTime % NUMBER_OF_SECONDS_TO_BLINK_YELLOW_LAMP == DEFAULT_ZERO){
			aBerlinClockBuilder.append(YELLOW_LAMP);
		}
		else{
			aBerlinClockBuilder.append(NO_LAMP);
		}
		aBerlinClockBuilder.append(CARRIAGE_RETURN);
		
	}

	/*
	 * performs the conversion of hours into equivalent berlin hours representation
	 * 
	 * */
	public void berlinClockHourRepresentation(int aHourTime, StringBuilder aBerlinClockBuilder){
		int numberOfTopRowLamps = DEFAULT_ZERO, numberOfSecondTopRowLamps = DEFAULT_ZERO;
		
		numberOfTopRowLamps = aHourTime / NUMBER_OF_HOURS_OF_TOP_ROW_LAMP;
		numberOfSecondTopRowLamps = aHourTime % NUMBER_OF_HOURS_OF_TOP_ROW_LAMP;
		
		hourAndMinuteRepresentationHelper(aBerlinClockBuilder, numberOfTopRowLamps, TimeProcessingConstants.NUMBER_OF_HOUR_LAMPS_TOP_TWO_ROWS, TimeType.HOUR);
		hourAndMinuteRepresentationHelper(aBerlinClockBuilder, numberOfSecondTopRowLamps, TimeProcessingConstants.NUMBER_OF_HOUR_LAMPS_TOP_TWO_ROWS, TimeType.HOUR);
		
	}
	
	/*
	 * performs the conversion of minutes into equivalent berlin minutes representation
	 * 
	 * */
	public void berlinClockMinuteRepresentation(int aMinuteTime, StringBuilder aBerlinClockBuilder){
		
		
		int numberOfSecondLastRowRedLamps = DEFAULT_ZERO, supportVariable = DEFAULT_ZERO, numberOfLastRowLamps = DEFAULT_ZERO, numberOfSecondLastRowYellowLamps = DEFAULT_ZERO;
		
		numberOfSecondLastRowRedLamps = aMinuteTime / NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_RED_LAMPS;
		numberOfSecondLastRowYellowLamps = aMinuteTime / NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_YELLOW_LAMPS - numberOfSecondLastRowRedLamps;
		
		supportVariable = aMinuteTime % NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_RED_LAMPS;
		numberOfLastRowLamps = supportVariable % NUMBER_OF_MINUTES_IN_SECOND_LAST_ROW_WITH_YELLOW_LAMPS;
		
		minuteRepresentationWithYellowRedLampsHelper(aBerlinClockBuilder, numberOfSecondLastRowRedLamps, numberOfSecondLastRowYellowLamps);
		hourAndMinuteRepresentationHelper(aBerlinClockBuilder, numberOfLastRowLamps, TimeProcessingConstants.NUMBER_OF_MINUTE_LAMPS_IN_LAST_ROW, TimeType.MINUTE);
		
		
	}

	/*
	 * helps to converts the hour/minute representation of to equivalent berlin representation
	 * 
	 * */
	private void hourAndMinuteRepresentationHelper(StringBuilder aBerlinClockBuilder, int aNumberOfLampsAfterCalculation, int aSpecifiedNumberOfLamps, TimeType aTimeComponent){
	
		for(int counter = DEFAULT_ZERO; counter < aSpecifiedNumberOfLamps; counter++){
			if(counter < aNumberOfLampsAfterCalculation){
				if(aTimeComponent == TimeType.HOUR)
					aBerlinClockBuilder.append(RED_lAMP);
				else
					aBerlinClockBuilder.append(YELLOW_LAMP);
			}
			else{
				aBerlinClockBuilder.append(NO_LAMP);
			}
		}
		
		if(TimeType.MINUTE != aTimeComponent){
			aBerlinClockBuilder.append(CARRIAGE_RETURN);
		}
		
	}
	
	/*
	 * helps to converts the minute representation of last second row to 
	 * equivalent berlin representation
	 * 
	 * */
	private void minuteRepresentationWithYellowRedLampsHelper(StringBuilder aBerlinClockBuilder, int aNumberOfSecondLastRowRedLamps, int anumberOfSecondLastRowYellowLamps) {
		
		int numberOfSecondLastRowYellowLampsCounter = DEFAULT_ONE, aNumberOfSecondLastRowRedLampsCounter = DEFAULT_ONE;

		for(int counter = DEFAULT_ONE; counter <= TimeProcessingConstants.NUMBER_OF_MINUTE_LAMPS_IN_SECOND_LAST_ROW; counter++){
			if(counter % QUARTER_OF_AN_HOUR == DEFAULT_ZERO && aNumberOfSecondLastRowRedLampsCounter <= aNumberOfSecondLastRowRedLamps){
				aBerlinClockBuilder.append(RED_lAMP);
				aNumberOfSecondLastRowRedLampsCounter++;
			}
			else if(numberOfSecondLastRowYellowLampsCounter <= anumberOfSecondLastRowYellowLamps){
				aBerlinClockBuilder.append(YELLOW_LAMP);
				numberOfSecondLastRowYellowLampsCounter++;
			}
			else{
				aBerlinClockBuilder.append(NO_LAMP);
			}
		}
		aBerlinClockBuilder.append(CARRIAGE_RETURN);
		
		
	}
}