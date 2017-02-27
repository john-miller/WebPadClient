package io.ess.webpad.client.service;

import io.ess.webpad.client.domain.Account;

/**
 * Contact defining functionality of the a security context
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public interface SecurityContext {
	
	public Account getPrincipal();
	
	public void setPrincipal(Account account);

}
