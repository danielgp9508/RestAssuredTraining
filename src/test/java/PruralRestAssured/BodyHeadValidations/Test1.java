package PruralRestAssured.BodyHeadValidations;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test(enabled = false)
	public void someTestGet() {
		
		given()
			.pathParam("users", "users")
			.queryParam("page", 2)
			.log().all()
			.when().
			get("https://reqres.in/api/{users}").
		then().
			statusCode(200);
		
	}
	
	@Test(enabled = false)
	public void someTestPost() {
		
		given().
			pathParam("users", "users").
			body("{\r\n"
					+ "    \"name\": \"Daniel\",\r\n"
					+ "    \"job\": \"QA\"\r\n"
					+ "}").
			log().all().
		when().
			post("https://reqres.in/api/{users}").	
		then().
			statusCode(201).
			log().all();
	}
	
	@Test(enabled = false)
	public void chainingTest() {
		System.out.println(new chaining()
		.id(2)
		.andThen()
		.name("Daniel")
		.andThen()
		.jobName("QA")
		.andThen()
		.toString());
	}
}
