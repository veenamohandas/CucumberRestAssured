package com.api.schema;

public class PatchRequestSchema {
	private String title;
	
public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

public PatchRequestSchema(String arg) {
	this.title=arg;
}
}
