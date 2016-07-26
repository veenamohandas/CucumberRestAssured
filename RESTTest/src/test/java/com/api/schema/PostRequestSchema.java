package com.api.schema;

public class PostRequestSchema {
	
	private String title;
	private String body ;
	private Integer userId;
	
	public PostRequestSchema(String arg1,String arg2,Integer arg3){
		this.title=arg1;
		this.body=arg2;
		this.userId=arg3;
	}

	
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

	
}
