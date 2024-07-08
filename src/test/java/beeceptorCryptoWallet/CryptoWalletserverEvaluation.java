package beeceptorCryptoWallet;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CryptoWalletserverEvaluation {
	
	String url = "https://crypto-wallet-server.mock.beeceptor.com"; //Set the base URI for the API
	@Test (enabled = false)
	public void Registerauser() {
		RestAssured.baseURI= url; //Set the base URI for RestAssured
		
		JSONObject js = new JSONObject(); // Create a new JSON object
		
		js.put("username", "user123"); // Add username to the JSON object
		js.put("password", "securepassword");
		js.put("email", "user@example.com");

		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/register").then().statusCode(200).log().all(); // Set the content type to JSON Set the request body to the JSON object Send a POST request to the /register endpoint

	}
	
	@Test (enabled = false)
	public void LogintheUser() {
		RestAssured.baseURI= url;
		
		JSONObject js = new JSONObject();
		
		js.put("username", "user123");
		js.put("password", "securepassword");
		
		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/login").then().statusCode(200).log().all();
	
	}
	//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
	@Test (enabled = false)
	public void Retrievethewalletbalance() {
		RestAssured.baseURI= url;
		given().get("/api/v1/balance").then().statusCode(200).log().all();
		
		
	}
	
	@Test (enabled = false)
	public void Listallthetransactionsdone() {
		RestAssured.baseURI= url;
		given().get("/api/v1/transactions").then().statusCode(200).log().all();
		
	}
	
	@Test (enabled = false)
	public void Transfer5ETHtoaRecipient() {
		RestAssured.baseURI= url;
		JSONObject js = new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", "5.0");
		js.put("currency", "ETH");
		
		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/transactions").then().statusCode(200).log().all();
		
		
	}
	
	@Test (enabled = false)
	public void CalculateTransactionFees() {
		RestAssured.baseURI= url;
		JSONObject js = new JSONObject();
		js.put("amount", "2.5");
		js.put("currency", "BTC");
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/transaction_fee").then().statusCode(200).log().all();
		
	}
	
	@Test (enabled = true)
	public void GetanObjectWithallAvailable() {
		RestAssured.baseURI= url;
		given().get("/api/v1/exchange_rates").then().statusCode(200).log().all();
			
	}
	

}
