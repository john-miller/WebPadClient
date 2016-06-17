package com.esg.webpad.service;

import com.esg.webpad.exception.NotePadFileException;
import com.esg.webpad.model.NotePadFile;

public interface NotePadFileService {

	public NotePadFile read(String notepadFile) throws NotePadFileException;
	
	public void save(NotePadFile file, String location) throws NotePadFileException;
	
}
