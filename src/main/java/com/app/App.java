package com.app;

import java.util.List;

import com.app.account.Model;
import com.app.account.ServiceClient;
import com.jk.util.JK;
import com.jk.util.JKObjectUtil;
import com.jk.web.services.client.JKServiceClient;

public class App {
	private static int id;

	public static void main(String[] args) {
		ServiceClient client = new ServiceClient();
		addRecord(client);
		printAll(client);
		find(client);
		delete(client);
		// find(client); this will throw an exception with 404 page not found
	}

	private static void delete(ServiceClient client) {
		client.delete(id);
	}

	private static void find(ServiceClient client) {
		// Retrieve single account
		Model account = client.find("/" + id);
		JK.printBlock(account);
	}

	private static void addRecord(ServiceClient client) {
		Model account = new Model();
		account.setNumber("1234");
		account.setName("Jalal");
		account.setAvg(100.3);
		account.setPhone("88888");
		account = client.insert(account);

		id = account.getId();// keep the current id for the later calls
	}

	private static void printAll(ServiceClient client) {
		// Retrieve all account
		List<Model> list = client.getAll();

		for (Model record : list) {
			JK.print(record);
		}
	}
}
