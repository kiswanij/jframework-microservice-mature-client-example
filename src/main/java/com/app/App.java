package com.app;

import java.util.List;

import com.app.person.Model;
import com.app.person.ServiceClient;
import com.jk.core.util.JK;

public class App {
	private static Model createdAccount;

	public static void main(String[] args) {
		ServiceClient client = new ServiceClient();
		addRecord(client);
		updateRecord(client);
		printAll(client);
		find(client);
		delete(client);
		// find(client); this will throw an exception with 404 page not found
	}

	private static void updateRecord(ServiceClient client) {
		createdAccount.setName("Updated - Jalal");
		client.update(createdAccount);
	}

	private static void delete(ServiceClient client) {
		client.delete(createdAccount.getId());
	}

	private static void find(ServiceClient client) {
		// Retrieve single account
		Model account = client.find("/" + createdAccount.getId());
		JK.printBlock(account);
	}

	private static void addRecord(ServiceClient client) {
		Model account = new Model();
		account.setNationalId("123456789");
		account.setName("Jalal Kiswani");
		account.setEmail("kiswanij@gmail.com");
		account.setAddress("Reno, NV");
		createdAccount= client.insert(account);

	}

	private static void printAll(ServiceClient client) {
		// Retrieve all account
		List<Model> list = client.getAll();

		for (Model record : list) {
			JK.print(record);
		}
	}
}
