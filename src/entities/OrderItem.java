package entities;

public class OrderItem {
	private Integer quantity;
	private Product product;
	
	public OrderItem() {
	
	}
	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer increaseQuantity(int quantity) {
		return this.quantity + quantity;
	}
	public Double getPrice() {
		return product.getPrice();
	}

	public Product getProduct() {
		return product;
	}
	
	public double subTotal() {
		return quantity * product.getPrice();
	}
	

	
	
	
}
