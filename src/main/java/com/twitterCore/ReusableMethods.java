package com.twitterCore;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class ReusableMethods {

	private static final Faker faker = new Faker();
	private Properties prop = new Properties();
	private static Logger log = LogManager.getLogger(ReusableMethods.class.getName());
	private String tweetId;
	
	private Properties loadEnvProp() throws IOException{
		File currentDir = new File("");		
		FileInputStream fis = new FileInputStream(currentDir.getAbsolutePath()+"/src/main/resources/env.properties");
		prop.load(fis);
		return prop;
	}
	
	protected JsonPath rawToJsonResponse(Response r){
		String responseString = r.asString();
		JsonPath jsonResp;
		jsonResp = new JsonPath(responseString);
		return jsonResp;
	}
	
	protected String getURI() throws IOException {
		return loadEnvProp().getProperty("HostURI");
	}

	protected RequestSpecification httpRequest() throws IOException {
		return given().auth().oauth(loadEnvProp().getProperty("ConsumerKey"), loadEnvProp().getProperty("ConsumerSecret"), loadEnvProp().getProperty("AccessToken"), loadEnvProp().getProperty("SecretToken"));
		
	}

	protected Response httpResponse(Response response) {
		return response.then().assertThat().and().contentType(ContentType.JSON).and().extract().response();
	}

	protected int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	private String writeFakerTweet() {
		return faker.lorem().sentence();
	}


	protected String createNewTweet() throws IOException
	{
		RestAssured.baseURI=getURI();
		Response res = httpRequest().queryParam("status",writeFakerTweet())
				.when().post(RequestPath.createTweet());
		httpResponse(res);
		Assert.assertEquals(getStatusCode(res) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		JsonPath jsonResp = rawToJsonResponse(res);
		tweetId=jsonResp.get("id").toString();
		log.info("Tweet id is:"+ tweetId);
		log.info("Tweet text is:"+ jsonResp.get("text"));
		return tweetId;

	}

	protected void getAllTweets() throws IOException
	{

		RestAssured.baseURI=getURI();
		Response res = httpRequest().queryParam("count", "1")
				.when().get(RequestPath.requestGetTweet());
		httpResponse(res);
		Assert.assertEquals(getStatusCode(res) /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		JsonPath jsonResp = rawToJsonResponse(res);
		log.info("All Tweets:"+ jsonResp);
	}
}
