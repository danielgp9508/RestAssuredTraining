package tests;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.testng.annotations.Test;



public class BasicValidationsTest {
	
	
	@Test(enabled = true)
	public void hashmapTest() {
		
		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("manzanas", 3);
		a.put("peras", 2);
		a.put("manzanas1", 2);
		System.out.println(a.values());
		Iterator it = a.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			System.out.println("clave: " + key + "valor: " + a.get(key));
		}
		Map<String, Player> b = new HashMap<String, Player>();
		b.put("Manchester1", new Player(10, "Daniel", "Arquero"));
		b.put("Real Madrid", new Player(9, "Alexander", "Defensa"));
		
		Iterator it1 = b.keySet().iterator();
		while(it1.hasNext()) {
			Object key = it1.next();
			System.out.println("valor: " + b.get(key).toString());
		}
	}
	
	@Test(enabled = false)
	public void properties() {
		
		Properties pro = new Properties();
		try {
			//pro.load(new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
			//		+ "resources" + File.separator + "properties" + File.separator + "test.properties")));
			//System.out.println(pro.getProperty("sp"));
			//System.out.println(System.getProperty("spring.version"));
			pro.load(BasicValidationsTest.class.getClassLoader().getResourceAsStream("test.properties"));
			System.out.println(pro.getProperty("sp"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=1, enabled = false)
	public void testStatusCode() {
	
		given().
		when().
			get("https://jsonplaceholder.typicode.com/posts/2").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test(priority=2, enabled = false)
	public void logResponseTest() {
		
			given().
				param("gender", "male").
			when().
				get("https://api.randomuser.me/?gender=male").
			then().
				statusCode(200).
				body("results[0].name.title" , equalTo("Mr")).
				log().all();
	}
	
	@Test(priority=3, enabled = false)
	public void logMultipleResponseTest() {
		
			given().
			when().
				get("https://dummy.restapiexample.com/public/api/v1/employees").
			then().
				statusCode(200).
				body("data.employee_name" , hasItems("Tiger Nixon","Cedric Kelly","Colleen Hurst")).
				log().all();
	}
}
