package com.app;

import java.util.List;

import com.app.person.ExampleServiceClient;
import com.app.person.Model;
import com.jk.core.util.JK;

public class App {
	private static Model createdAccount;

	public static void main(String[] args) {
		ExampleServiceClient client = new ExampleServiceClient();
		addRecord(client);
		updateRecord(client);
		printAll(client);
		find(client);
		delete(client);
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

	private static void addRecord(ExampleServiceClient client) {
		Model account = new Model();
		account.setNationalId("123456789");
		account.setName("Jalal Kiswani");
		account.setEmail("kiswanij@gmail.com");
		account.setAddress("Reno, NV");
		createdAccount= client.insert(account);

	}

	private static void printAll(ExampleServiceClient client) {
		// Retrieve all account
		List<Model> list = client.getAll();

		for (Model record : list) {
			JK.print(record);
		}
	}
}
