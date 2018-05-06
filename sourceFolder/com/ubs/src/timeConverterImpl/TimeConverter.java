package com.ubs.src.timeConverterImpl;

import com.src.constant.TimeProcessingConstants;



/**
 * @author Prashant
 *
 */
public interface TimeConverter extends TimeProcessingConstants{
    /**
     * @param aTime
     * @return
     */
    @SuppressWarnings("javadoc")
	String convertTime(String aTime);
}
