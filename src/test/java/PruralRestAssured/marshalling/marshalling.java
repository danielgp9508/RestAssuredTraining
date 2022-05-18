package PruralRestAssured.marshalling;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

public class marshalling {
	
	public String BASE_URL = "https://api.github.com/users/rest-assured";
	public String BASE_URL_2 = "https://reqres.in/api/users?page=2";
	
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void objectMappingTestOne() {
		User user = RestAssured.get(BASE_URL)
				.as(User.class);
		
		assertEquals(user.getLogin(), "rest-assured");
		assertEquals(user.getId(), 19369327);
		assertEquals(user.getPublicRepos(), 2);
	}
	
	@Test
	public void objectMappingRelyingOnMapperType() {
		User user = RestAssured.get(BASE_URL)
				.as(User.class, ObjectMapperType.JACKSON_2);
	}
	
	@Test
	public void objectmapping2() {
		User2 user = RestAssured.get(BASE_URL_2)
				.as(User2.class);
		
		System.out.println("*** " + user.getData());
		System.out.println("*** " + user.getId());
		assertEquals(user.getIntper_page(), 6);
		assertEquals(user.getPage(), 2);
		assertEquals(user.getTotal(), 12);
		assertEquals(user.getId(), 7);
		
	}
	
	@Test
	public void objectMappingSerialization() {
		
		PostExample pe = new PostExample();
		pe.setName("danilson");
		pe.setJob("QA1");
		
		given()
			.contentType(ContentType.JSON)
			.body(pe)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
		
	}
	
	@Test
	public void objectMappingDeSerialization() {
		
		PostExample pe = new PostExample();
		pe.setName("danilson");
		pe.setJob("QA1");
		
		PostExample rest = given()
			.contentType(ContentType.JSON)
			.body(pe)
		.when()
			.post("https://reqres.in/api/users")
			.as(PostExample.class);
		
		System.out.println(rest.getName());
		System.out.println(rest.getJob());
		System.out.println(rest.getId());
		System.out.println(rest.getCreatedAt());
		

		
	}
	
}
