package com.esg.webpad.model;

public class NotePadFile {

	private String name;
	private String description;
	private String encryptedData;
	private transient String content;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String data) {
		this.encryptedData = data;
	}
	
}
