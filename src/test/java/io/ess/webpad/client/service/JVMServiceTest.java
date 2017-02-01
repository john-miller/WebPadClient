package io.ess.webpad.client.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class JVMServiceTest {
	
	@Test
	public void instantiate() {
		assertNotNull(JVMService.INSTANCE);
	}
	
	@Test
	public void FXCompatibilityTest() {
		assertNotNull(JVMService.INSTANCE.supportsJavaFX());
	}

}
