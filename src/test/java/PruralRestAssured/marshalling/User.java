package PruralRestAssured.marshalling;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private String login;
	
	private int id;
	
	@JsonProperty("public_repos")
	private int publicRepos;
	
	public int getPublicRepos() {
		return publicRepos;
	}

	public String getLogin() {
		return login;
	}
	
	public int getId() {
		return id;
	}

	
	

}
