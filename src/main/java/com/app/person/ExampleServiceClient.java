package com.app.person;

import com.jk.core.config.JKConfig;
import com.jk.services.client.JKMatureServiceClient;

public class ExampleServiceClient extends JKMatureServiceClient<Model> {

	@Override
	public String getBase() {
		return JKConfig.get().getProperty("app.services.persons.url");
	}

}
