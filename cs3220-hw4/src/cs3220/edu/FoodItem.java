package cs3220.edu;

public class FoodItem {
final int id;
final String name;
final String description;
public final String imageUrl;
final double price;

public FoodItem(int id, String name, String description, String imageUrl, double price) {

	this.id = id;
	this.name = name;
	this.description = description;
	this.imageUrl = imageUrl;
	this.price = price;
}


public int getId() {
	return id;
}

public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public String getImageUrl() {
	return imageUrl;
}

public double getPrice() {
	return price;
}

}