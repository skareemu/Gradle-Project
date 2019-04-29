package com.twitterAPI_E2E;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.twitterCore.ReusableMethods;

public class E2E_Tweet_GetAllTweets extends ReusableMethods{

	private static Logger log = LogManager.getLogger(E2E_Tweet_DeleteTweet.class.getName());

	@Test(description = "Feature Tweet_GetAllTweets_E2E - CreateNewTweet")
	public void newTweet() {
		try {
			createNewTweet();
		} catch (Exception e)
		{
			log.error(e);
		}
	}

	@Test(description = "Feature Tweet_GetAllTweets_E2E - GetAllTweets")
	public void getTweets() {
		try {
			getAllTweets();
		} catch (Exception e){
			log.error(e);
		}
	}

}
