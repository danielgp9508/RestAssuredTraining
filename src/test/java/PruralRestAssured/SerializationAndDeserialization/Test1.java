package PruralRestAssured.SerializationAndDeserialization;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;


public class Test1 {
	
	public static final String BASE_URL = "https://reqres.in/api/users?page=2";
	
	@Test
	public void test() {
		
		FullJson fj = RestAssured.get(BASE_URL)
				.as(FullJson.class);
		
		System.out.println(fj.getData().get(1).getId());
		System.out.println(fj);
		
		List<Data> list = fj.getData();
		for(Data value : list) {
			System.out.println(value.getId());
		}
		

		
		
	}

}
