package com.app.model;

import com.jk.web.services.client.JKMatureServiceClient;

public class AccountServiceClient extends JKMatureServiceClient<Account>{

	@Override
	public String getServiceUrlPropertyName() {
		return "app.services.account.url";
	}

}
