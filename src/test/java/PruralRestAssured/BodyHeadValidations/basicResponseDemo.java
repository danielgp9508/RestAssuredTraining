package PruralRestAssured.BodyHeadValidations;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class basicResponseDemo {
	
	public static final String BASE_URL = "https://api.github.com";
	
	@Test
	public void convenienceMethods() {
		
		given()
		.when()
		.get(BASE_URL)
		.peek()
		.then()
		.statusCode(200)
		.contentType("application/json; charset=utf-8");	
	}
	
	@Test
	public void genericHeaders() {
		
		given()
		.when()
		.get(BASE_URL)
		.then()
		.assertThat()
		.header("server", "GitHub.com")
		.and()
		.header("x-ratelimit-limit", "60");
	}
	
	@Test
	public void getHeaders() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("server", "GitHub.com");
		map.put("x-ratelimit-limit", "60");
		
		given()
		.when()
		.get(BASE_URL)
		.then()
		.headers(map); 
	}
	
	@Test
	public void hamcrestBasic() {
		
		given()
		.when()
		.get(BASE_URL)
		.then()
		.statusCode(Matchers.lessThan(300))
		.header("cache-control", Matchers.containsStringIgnoringCase("max-age=60"))
		.time(Matchers.lessThan(2L), TimeUnit.SECONDS)
		.header("etag", Matchers.notNullValue());
	}
	
	@Test
	public void hamcrestComplex() {
		
		given()
		.when()
		.get(BASE_URL)
		.then()
		.header("x-ratelimit-limit", Integer::parseInt, equalTo(60))
		.header("X-RateLimit-Limit", response -> lessThan(response.header("X-RateLimit-Remaining")));
	}
	

}
