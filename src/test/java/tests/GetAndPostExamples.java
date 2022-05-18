package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	@Test(enabled = false)
	public void testGet() {
		
//		baseURI = "https://reqres.in/api";
//		
//		given().get(baseURI + "/users?page=2").then().statusCode(200).
//		body("data[1].first_name", equalTo("Lindsay")).
//		body("data.first_name", hasItems("Michael","Lindsay","Tobias","Rachel"));
		
		given()
		.when()
			.get("https://dummy.restapiexample.com/public/api/v1/employees").
		then()
			.statusCode(200)
			.body("status", equalTo("success"))
			.log().body();
			//.extract().response();
		//System.out.println(response.asString());
		//System.out.println(response);
		
		
	}
	
	@Test
	public void testGet2() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("h1", "a1");
		map.put("h2", "a2");
		map.put("h3", "a3");
		
		given().
			pathParam("testpath", "pathName").
			queryParam("name", "daniel").
			queryParam("hola", "test").
			
			//param("name", "daniel").
			//param("hola", "test").
			cookie("abc123").
			header("Cookie","abs234").
			headers(map).
			log().all().
		when().
			get("https://api.agify.io/{testpath}").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void testPost() {
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("email", "Danilson@asdas");
	map.put("password", "teacher");
	
	//JSONObject request1 = new JSONObject(map);
	//JSONObject request2 = new JSONObject(map);
	//request1.put("name", "Danilson");
	//request1.put("job", "teacher");
	//request2.put("email", "Danilson@gmail.com");
	//request2.put("job", "abc123");
	//System.out.println(request2.toJSONString());
	baseURI = "https://reqres.in/api";
	given().
		body("{\"email\"=\"teacher\", \"password\"=\"Danilson@asdas\"}").
	when().
		post(baseURI + "/users").
	then().
		statusCode(201).log().body();
	//given().body(request2.toJSONString()).when().post(baseURI + "/login").then().statusCode(200).log().body();
	}
	
	@Test
	public void testPost2() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		JSONObject request = new JSONObject(map);
//		request.put("Id", );
//		given().header("","")
	}
}
