package io.ess.webpad.client.service;

public enum JVMService {
	
	INSTANCE;
	
	public boolean supportsJavaFX() {
		try {
			Class.forName("com.sun.javafx.application.PlatformImpl");
			return true;
		} catch(ClassNotFoundException e) {
			return false;
		}
	}
	
}
