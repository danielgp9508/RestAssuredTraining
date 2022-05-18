package PruralRestAssured.BodyHeadValidations;

import static io.restassured.RestAssured.given;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.*;

public class BodyValidation {
	
public static final String BASE_URL = "https://api.github.com/";
public static final String BASE_URL1 = "https://reqres.in/api/users?page=2";


	@Test
	public void jsonPathValidation() {
		
		Response response = (Response) given()
		.when()
		.get(BASE_URL + "rate_limit")
		.body();
		
		System.out.println("***" + response.jsonPath().get());
		
		ResponseBody<?> body =  response;
		JsonPath jpath = body.jsonPath();
		
		JsonPath jpath1 = response.jsonPath();
		
		Map<String, String> fullJson = jpath1.get();
		Map<String, ?> subMap = jpath1.get("resources");
		Map<String, ?> subMap2 = jpath1.get("resources.core");
		
		int value = jpath1.get("resources.core.remaining");
		int value1 = jpath1.get("resources.core.used");
		
		Map<String, String> try1 = new HashMap<String ,String>();
		try1.put("a", "L");
		try1.put("b", "B");
		System.out.println(try1);
		
		
		System.out.println(fullJson);
		System.out.println((( Map) subMap.get("core")).get("limit"));
		System.out.println(subMap2);
		System.out.println(value);
		System.out.println(value1);
		
		
	}
	
	@Test
	public void validateResponseBodu() {
		
		given()
		.when()
		.get(BASE_URL)
		.then()
		.body("current_user_url", equalTo(""))
		.body(containsString("feeds_url"));
	}
	
	@Test
	public void complexBodyExample() {
		
		given()
		.when()
		.get(BASE_URL + "users/danielgp9508")
		.then()
		.body("url", response -> Matchers.containsStringIgnoringCase(response.body().jsonPath().get("login")));
	}
	
	@Test
	public void nestedBodyValidation() {
		
		given()
		.when()
		.get(BASE_URL + "rate_limit")
		.then()
		.rootPath("resources.core")
			.body("limit", equalTo(60))
			.body("remaining", lessThan(60))
			.body("limit", nullValue())
		.rootPath("resources.search")
			.body("limit", equalTo(10))
			.body("remaining", lessThan(11));
		
	}
	
	@Test
	public void repeteadValues() {
		
		given()
		.when()
		.get(BASE_URL1)
		.then()
			.body("data.id[0]", equalTo(7))
			.body("data.first_name[1]", equalTo("Lindsay"))
			.body("data.first_name", hasItems("Tobias", "George", "Rachel"));
		
	}
	
	@Test
	public void parser() {
		
		given()
		.when()
		.get(BASE_URL1)
		.then()
		.using()
			.defaultParser(Parser.XML)
		.body("", equalTo(""));
		
		
	}
	
	
	
}
