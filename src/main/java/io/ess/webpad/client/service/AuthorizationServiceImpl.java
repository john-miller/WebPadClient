package io.ess.webpad.client.service;

import io.ess.webpad.client.domain.Account;

/**
 * Holds the currently authenticated user in memory
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public enum InMemorySecurityContextImpl implements SecurityContext {
	
	INSTANCE;
	
	private Account currentAccount;

	public Account getPrincipal() {
		return currentAccount;
	}

	public void setPrincipal(Account account) {
		this.currentAccount = account;
	}

}
