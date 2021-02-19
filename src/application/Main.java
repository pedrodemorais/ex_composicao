package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();
		System.out.print("Bith date (DD/MM/YYYY): ");
		Date dateBirth = sdf.parse(input.nextLine());

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = input.nextLine();

		Order order = new Order(date = new Date(), OrderStatus.valueOf(status), new Client(name, email, dateBirth));
		// System.out.println(order.toString());

		System.out.print("How many items to this order? ");
		int numOfItems = input.nextInt();
		
			for (int i = 0; i < numOfItems; i++) {
				input.nextLine();
				
				System.out.print("Enter #"+(1+i)+" item data:");
				System.out.print("\nProduct name: ");
				String nameProduct = input.nextLine();
				System.out.print("Product price: ");
				Double productPrice = input.nextDouble();
				
				Product product =new Product(nameProduct, productPrice); 
				
				System.out.print("Quantity: ");
				int quantity = input.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product );
			order.addItem(orderItem);

		}
			System.out.println(order);
			
		input.close();	

	}

}
