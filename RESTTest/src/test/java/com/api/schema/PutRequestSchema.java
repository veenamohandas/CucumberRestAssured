package com.api.schema;

public class PutRequestSchema {
	protected String title;
	protected String body ;
	protected Integer userId;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public PutRequestSchema(String arg1,String arg2,Integer arg3){
		this.title=arg1;
		this.body=arg2;
		this.userId=arg3;
	}


}
