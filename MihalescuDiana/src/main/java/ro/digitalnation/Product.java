package ro.digitalnation;

public class Product {

	long id;
	String title, description;
	double price;
	public Product(long id, String title, String description, double price) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
