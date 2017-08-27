package persistence;

public class PriceInfo extends Entity {
	private String product;
	private String discounter;
	private int price;

	public PriceInfo(String product, String discounter, int price) {
		this.discounter = discounter;
		this.product = product;
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDiscounter() {
		return discounter;
	}

	public void setDiscounter(String discounter) {
		this.discounter = discounter;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
