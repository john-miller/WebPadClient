package io.ess.webpad.client.login;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ess.webpad.client.login.LoginControllerImpl;

public class LoginControllerImplTest {
	
	@Test
	public void instantiate() {
		assertNotNull(new LoginControllerImpl());
	}

}
