package task1_4;

public class Product {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public int compareTo(Product otherP) {
		int res = name.compareTo(otherP.name);
		if (res == 0) {
			res = Double.compare(price, otherP.price);
		}
		return res;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + price + ", " + type;
	}

}
