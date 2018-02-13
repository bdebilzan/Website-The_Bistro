package cs3220.edu;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Order{
	public final int id;
	public final int qty;
	public String foodItems;
	public final String customerName;
	public enum Statuses
	{
		IN_QUEUE, 
		IN_PROGRESS, 
		COMPLETED;
	};
	public final String status;
	public final Date created;
	

	public Order (int id, String foodItems, String customerName, String status, Date created,int qty) {
		this.id = id;
		this.foodItems = foodItems;
		this.customerName = customerName;
		this.status = status;
		this.created = created;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public String getItems() {
		return foodItems;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public String getStatuses() {
		return status;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public int getQty()
	{
		return qty;
	}
}