package com.app;

import java.util.List;

import com.app.model.Account;
import com.app.model.AccountServiceClient;
import com.jk.util.JK;
import com.jk.web.services.client.JKServiceClient;

public class App {
	public static void main(String[] args) {
		AccountServiceClient client=new AccountServiceClient();
		addRecord(client);
		printAll(client);
		find(client);		
		delete(client);
		find(client);
		
	}

	private static void delete(AccountServiceClient client) {
		client.callJsonWithDelete("/1");		
	}

	private static void find(AccountServiceClient client) {
		// Retrieve single account
		Account account = client.callSingleJson("/1");
		JK.printBlock(account);
	}

	private static void addRecord(AccountServiceClient client) {
		Account account=new Account();
		account.setNumber("1234");
		account.setName("Jalal");
		account.setAvg(100.3);
		account.setPhone("88888");
		client.callJsonWithPost(account);
	}

	private static void printAll(AccountServiceClient client) {
		// Retrieve all account
		List<Account> list = client.callJsonAsListOfObjects();

		for (Account record: list) {
			JK.print(record);
		}
	}
}
