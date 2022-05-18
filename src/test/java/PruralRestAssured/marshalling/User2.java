package PruralRestAssured.marshalling;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User2 {
	
	@JsonProperty("page")
	private int page;
	
	@JsonProperty("per_page")
	private int intper_page;
	
	@JsonProperty("total")
	private int total;
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("id")
	private List<?> id;
	
	@JsonProperty("data")
	private Object data;
	
	public Object getData() {
		return data;
	}
	public int getPage() {
		return page;
	}
	public int getIntper_page() {
		return intper_page;
	}
	public int getTotal() {
		return total;
	}
	public Object getId() {
		return id;
	}

}
