package task1_4;

public class OrderItem {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}

	public int compareTo(OrderItem o) {
		return p.compareTo(o.p);
	}

	public int compare(Product otherP) {
		int byName = p.getName().compareTo(otherP.getName());
		if (byName == 0)
			return Double.compare(p.getPrice(), otherP.getPrice());
		return byName;
	}

	public Product getP() {
		return p;
	}

	public int getQuality() {
		return quality;
	}


	@Override
	public String toString() {
		return p + ", " + quality;
	}

}
