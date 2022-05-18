package PruralRestAssured.BodyHeadValidations;

public class chaining {
	
	private int id;
	private String name;
	private String jobName;
	
	public chaining id(int id) {
		this.id = id;
		return this;
	}
	
	public chaining name(String name) {
		this.name = name;
		return this;
	}
	
	public chaining jobName(String jobName) {
		this.jobName = jobName;
		return this;
	}
	
	//Syntactic Sugar
	public chaining andThen() {
		return this;
	}
	
	public String toString() {
		return Integer.toString(id) + " " + name + " " + jobName;
		
	}

}
