package SerializationAndDeserialization;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class SerializationJson {
	
	@Test(priority = 1)
	public void createNewStudentSerialization() {
		
		ArrayList<String> courseList = new ArrayList<String>();
		
		courseList.add("Java");
		courseList.add("Selenium");
		
		Student std = new Student();
		std.setId(101);
		std.setFirstName("Daniel");
		std.setLastName("Grajales");
		std.setEmail("asdasd@asda.com");
		std.setProgramme("Math");
		std.setCourses(courseList);
		given().
			contentType(ContentType.JSON).
			body(std).
		when().
			post("asdasdasd/asdas").
		then().
			statusCode(201);
		
	}
	
	@Test(priority = 2)
	public void getStudentCreation() {
		
		Student std = get("asdasdas").as(Student.class);
		
	}
}
