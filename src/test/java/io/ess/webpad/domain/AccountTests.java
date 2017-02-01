package io.ess.webpad.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ess.webpad.client.domain.Account;

public class AccountTests {
	
	@Test
	public void instantiate() {
		assertNotNull(new Account());
	}
	
	@Test
	public void usernameTest() {
		String username = "test";
		Account account = new Account();
		account.setUsername(username);
		assertEquals(username, account.getUsername());
	}

}
