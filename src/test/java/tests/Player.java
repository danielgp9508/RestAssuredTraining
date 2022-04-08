package tests;

public class Player {
	
	private int backNumber;
	private String name;
	private String position;
	
	
	public Player(int backNumber, String name, String position) {
		this.backNumber = backNumber;
		this.name = name;
		this.position = position;
	}
	
	public int getBackNumber() {
		return backNumber;
	}
	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String toString() {
		return this.name + " -- " + this.position + " -- " + this.backNumber;
	}
	

}
