package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

public class BasicValidationXML {

	@Test(priority = 1)
	public void singleValidation() {
		
		given().
		when().
			get("https://www.w3schools.com/xml/cd_catalog.xml").
		then().
			body("CATALOG.CD[0].TITLE",equalTo("Empire Burlesque")).
			log().all();
	}
	
	@Test(priority = 2)
	public void multipleValidation() {
		
		given().
		when().
			get("https://www.w3schools.com/xml/cd_catalog.xml").
		then().
			body("CATALOG.CD[0].text()",equalTo("Empire BurlesqueBob DylanUSAColumbia10.901985")).
			log().all();
	}
	
	@Test(priority = 3)
	public void testUsingXpath1() {
		
		given().
		when().
			get("https://www.w3schools.com/xml/cd_catalog.xml").
		then().
			body(hasXPath("/CATALOG/CD[1]/COMPANY"),containsString("Columbia")).
			log().all();
	}
	
	@Test(priority = 4)
	public void testUsingXpath2() {
		
		given().
		when().
			get("https://www.w3schools.com/xml/cd_catalog.xml").
		then().
			body(hasXPath("/CATALOG/CD/YEAR[text()='1990']")).
			log().all();
	}
}
