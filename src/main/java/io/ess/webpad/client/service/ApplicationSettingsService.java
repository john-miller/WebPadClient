package io.ess.webpad.client.service;

import io.ess.webpad.client.domain.ApplicationSettings;

public interface ApplicationSettingsService {

	public ApplicationSettings load() throws ApplicationSettingsServiceException;
	
	public void save(ApplicationSettings applicationSettings) throws ApplicationSettingsServiceException;
	
}

