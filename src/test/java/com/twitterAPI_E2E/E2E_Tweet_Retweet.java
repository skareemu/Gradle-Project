package com.twitterAPI_E2E;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.twitterCore.RequestPath;
import com.twitterCore.ReusableMethods;

import java.io.IOException;

public class E2E_Tweet_Retweet extends ReusableMethods{

    public String tweetId;

	private static Logger log = LogManager.getLogger(E2E_Tweet_Retweet.class.getName());

	@Test(description = "Feature Tweet_ReTweet_E2E - CreateRetweet")
	public void createReTweetE2E() throws IOException
	{
		RestAssured.baseURI=getURI();
		try {
			Response res = httpRequest()
					.when().post(RequestPath.reTweet(createNewTweet()));
			httpResponse(res);
			Assert.assertEquals(getStatusCode(res) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
			JsonPath jsonResp = rawToJsonResponse(res);
			log.info("ReTweet text is:" + jsonResp.get("text"));
		} catch (Exception e) {
			log.error(e);
		}

	}

}
