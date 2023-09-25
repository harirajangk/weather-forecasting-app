package com.weather.exception;

public class OpenWeatherMapApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public OpenWeatherMapApiException() {
        super();
    }

    public OpenWeatherMapApiException(String message) {
        super(message);
    }

    public OpenWeatherMapApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
