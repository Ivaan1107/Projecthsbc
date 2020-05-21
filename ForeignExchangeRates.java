package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForeignExchangeRates {
	HttpResponse httpResponse;
	static String url;
	
	@Given("^Rates API for Latest Foreign Exchange rates$")
	//Add rest API for given condition
	public void setPostEndPoint()
	{
		
		HttpUriRequest request = new HttpGet( "https://api.ratesapi.io/api/latest HTTP/2" );
		
	}
	@When("^The API is available$")
	public void APIAvailable()
	{
		httpResponse = HttpClientBuilder.create().build().execute( request );
	}
	@When("^An incorrect or incomplete url is provided$")
	public void wrongURL()
	{
		
	}
	@Then("^An automated test suite should run which will assert the success status of the response$")
	public void statusCode()
	{
		int statusCode = httpResponse.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	@Then("^An automated test suite should run which will assert the response$")
	public void assertResponse()
	{
	HttpResponse response = HttpClientBuilder.create().build().execute( httpResponse );
	System.out.println(response);
	}
	@Then("^Test case should assert the correct response supplied by the call$")
	public static String getStatus() throws IOException {
		 
		String result = "";
		int code = 200;
		try {
			url="https://api.ratesapi.io/api/latest HTTP/2";
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
 
			code = connection.getResponseCode();
			if (code == 200) {
				result = "Green and code is:" + code;
				;
			} else {
				result = "Yellow and code is" + code;
			}
		} catch (Exception e) {
			result = "Red Wrong domain - Exception: " + e.getMessage();
 
		}
		System.out.println(url + "\t\tStatus:" + result);
		return result;
	}
 
}
	


