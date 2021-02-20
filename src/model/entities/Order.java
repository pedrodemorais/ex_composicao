package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem orderItem ) {
		items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem ) {
		items.add(orderItem);
	}
	
	public Double total() {
		Double sum=0.0;
		
		for(OrderItem x:items) {
			sum +=x.subTotal();
			
		}
		
		return sum; 
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY: ");
		sb.append("\nOrder moment: "+sdf.format(moment));
		sb.append("\nOrder Status: "+getStatus());
		sb.append("\nClient: "+getClient().getName()+" ("+sdf1.format(getClient().getBirthDate())+")");
		sb.append(" - "+getClient().getEmail());
		sb.append("\nOrder Items: \n");
		for(OrderItem item: items) {
			sb.append(item+"\n");
			
		}
		sb.append("Total price: R$  "+total());
		//sb.append(total());
		
		return sb.toString(); 
	}
				

	
	
	

}
