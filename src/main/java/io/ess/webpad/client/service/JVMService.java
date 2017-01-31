package io.ess.webpad.client.service;

/**
 * Provides common JVM Utilities
 * 
 * @author Jonathan Miller
 */
public enum JVMService {
	
	INSTANCE;
	
	public static final String JAVAFX_INDICATOR_CLASS = "com.sun.javafx.application.PlatformImpl";
	
	/**
	 * Will attempt to get the JAVAFX_INDICATOR_CLASS
	 * by name.  If it succeeds, it is very likely that the client
	 * supports JavaFX
	 * @return
	 */
	public boolean supportsJavaFX() {
		try {
			Class.forName(JAVAFX_INDICATOR_CLASS);
			return true;
		} catch(ClassNotFoundException e) {
			return false;
		}
	}
	
}
