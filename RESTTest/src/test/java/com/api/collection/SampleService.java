package com.api.collection;

import com.api.service.config.Config;

public class SampleService {
	//These are the urls to the service as I dont have a name for themI am calling as get
	public static String getUserRequest=Config.envUrl+"/posts/";
	public static String postUserRequest=Config.envUrl+"/posts/";
	public static String putUserRequest=Config.envUrl+"/posts/";
	public static String patchUserRequest=Config.envUrl+"/posts/";
	public static String deleteUsersRequest=Config.envUrl+"/posts/";
	
}
