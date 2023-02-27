package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	private Client client;
	
	public Order() {
		
	}
	public Order(Date moment,OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void addOrderItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	public Client getClient() {
		return client;
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem oi: orderItem) {
			sum+= oi.subTotal();
		}return sum;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status+"\n");
		sb.append("Client: ");
		sb.append(client.getName());
		sb.append(" ("+  sdf2.format(client.getBirthDate()));
		sb.append(") "+"- ");
		sb.append(client.getEmail()+"\n");
		for (OrderItem i: orderItem) {
			sb.append(i.getProduct().getName()+", ");
			sb.append("$"+i.getProduct().getPrice()+", ");
			sb.append("Quantity: "+i.getQuantity()+", ");
			sb.append("Subtotal: $"+i.subTotal()+"\n");
		}
		sb.append("Total Price $" + total());
		return sb.toString();
	}
		
	
}
