package io.ess.webpad.client.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.ess.webpad.client.domain.Account;

public class InMemorySecurityContentImplTest {
	
	@Test
	public void instantiate() {
		assertNotNull(InMemorySecurityContextImpl.INSTANCE);
	}
	
	@Test
	public void principalTests() {
		Account account = new Account();
		InMemorySecurityContextImpl.INSTANCE.setPrincipal(account);
		assertEquals(account, InMemorySecurityContextImpl.INSTANCE.getPrincipal());
	}

}
