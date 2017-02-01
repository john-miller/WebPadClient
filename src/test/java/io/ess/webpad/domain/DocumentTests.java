package io.ess.webpad.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import io.ess.webpad.client.domain.Document;

public class DocumentTests {
	
	@Test
	public void instantiate() {
		assertNotNull(new Document());
	}
	
	@Test
	public void bodyTest() {
		String  body = "test";
		Document doc = new Document();
		doc.setBody(body);
		assertEquals(body, doc.getBody());
	}
	
	@Test
	public void nameTest() {
		String name = "test";
		Document doc = new Document();
		doc.setName(name);
		assertEquals(name, doc.getName());
	}
	
	@Test
	public void lastUpdateTest() {
		Date date = new Date();
		Document doc = new Document();
		doc.setLastUpdated(date);
		assertEquals(date, doc.getLastUpdated());
	}
	
	@Test
	public void createdOnTest() {
		Date date = new Date();
		Document doc = new Document();
		doc.setCreatedOn(date);
		assertEquals(date, doc.getCreatedOn());
	}
	

}
