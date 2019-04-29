package com.twitterCore;

public class RequestPath {
	
	public static String requestGetTweet()
	{
        return "/home_timeline.json";
	}

	public static String createTweet()
	{
		return  "/update.json";
	}

	public static String reTweet(String id)
	{
        return "/retweet/"+id+".json";
	}

	public static String deleteTweet(String id)
	{
        return "/destroy/"+id+".json";
	}

}
