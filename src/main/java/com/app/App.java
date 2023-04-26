package com.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.app.person.ExampleServiceClient;
import com.app.person.Model;
import com.jk.core.util.JK;
import com.jk.core.util.JKDateTimeUtil;
import com.jk.core.util.JKIOUtil;
import com.jk.core.util.JKObjectUtil;

public class App {
	private static Model createdAccount;

	public static void main(String[] args) throws ParseException {
		ExampleServiceClient client = new ExampleServiceClient();
		addRecord(client);
//		updateRecord(client);
//		printAll(client);
//		find(client);
//		delete(client);
		// find(client); this will throw an exception with 404 page not found
	}

	private static void updateRecord(ExampleServiceClient client) {
		createdAccount.setName("Updated - Jalal");
		client.update(createdAccount);
	}

	private static void delete(ExampleServiceClient client) {
		client.delete(createdAccount.getId());
	}

	private static void find(ExampleServiceClient client) {
		// Retrieve single account
		Model account = client.find("/" + createdAccount.getId());
		JK.printBlock(account);
	}

	private static void addRecord(ExampleServiceClient client) throws ParseException {
//		String dateText = "12/03/2023";
//		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
//
//		
//		Model account = new Model();
//		account.setNationalId("123456789");
//		account.setName("Jalal Kiswani");
//		account.setEmail("kiswanij@gmail.com");
//		account.setAddress("Reno, NV");
//		account.setBirthDate(date);
		
//		String json = JKObjectUtil.toJson(account);
		String json=JKIOUtil.readFile("test2.txt");
		
		System.out.println(json);
		
		
		Model jsonToObject = JKObjectUtil.jsonToObject(json, Model.class);
//		System.out.println(account.getBirthDate());
		System.out.println(jsonToObject.getBirthDate());
		//createdAccount= client.insert(account);

	}

	private static void printAll(ExampleServiceClient client) {
		// Retrieve all account
		List<Model> list = client.getAll();

		for (Model record : list) {
			JK.print(record);
		}
	}
}
