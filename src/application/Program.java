package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = sc.nextLine();
		Date moment = new Date();
		Order order = new Order(moment,OrderStatus.valueOf(status),new Client(name,email,birthDate));
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		
		for (int i = 0; i < n;i++) {
			sc.nextLine();
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name:");
			String productName = sc.nextLine();
			System.out.print("Product price:");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem item = new OrderItem(productQuantity, new Product(productName,productPrice));
			order.addOrderItem(item);
			
			
			
			
		}
		
		System.out.println("ORDER SUMMARY:");
		
		System.out.println(order);
		
		
		
		
		sc.close();

	}

}
