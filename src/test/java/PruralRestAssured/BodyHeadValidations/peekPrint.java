package PruralRestAssured.BodyHeadValidations;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class peekPrint {
	
	public static final String BASE_URL = "https://api.github.com";
	@Test
	public void peek() {
		
		given()
		.when()
		.get(BASE_URL)
		.peek()
		.then();
		
	}
	
	@Test
	public void prettyPeek() {
		
		given()
		.when()
		.get(BASE_URL)
		.prettyPeek()
		.then();
		
	}
	
	@Test
	public void print() {
		
		given()
		.when()
		.get(BASE_URL)
		.print();
		
	}
	
	@Test
	public void prettyPrint() {
		
		given()
		.when()
		.get(BASE_URL)
		.prettyPrint();
	}

}
