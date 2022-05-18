package tests;

public class CarFeatures {
	
	private int id;
	private String color;
	private String brand;
	
	
	@Override
	public String toString() {
		return "CarFeatures [id=" + id + ", color=" + color + ", brand=" + brand + "]";
	}


	public CarFeatures(int id, String color, String brand) {
		super();
		this.id = id;
		this.color = color;
		this.brand = brand;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

}
