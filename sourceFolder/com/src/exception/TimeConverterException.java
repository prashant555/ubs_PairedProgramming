package com.src.exception;

import java.io.Serializable;

/*
 * Handles the exception while process the time conversion logic
 * 
 * */
/**
 * @author Prashant
 *
 */
public class TimeConverterException extends Exception implements Serializable{

	private static final long serialVersionUID = -4861175905458273860L;

	/**
	 * @param message
	 */
	public TimeConverterException(String message) {
		super(message);
	}
}
