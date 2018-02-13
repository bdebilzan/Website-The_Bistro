package cs3220.edu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderDAO implements DAO<Order> {
	public void add(Order entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (id, items, customername, status, created, qty) VALUES ( ?,?,?,?,?)");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getItems());
            pstmt.setString(3, entry.getCustomerName());
            pstmt.setString(4, entry.getStatuses()); 
            pstmt.setDate(5,(Date) entry.getCreated());
            pstmt.setInt(6, entry.getQty()); 
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Order> list() {
		 List<Order> list = new ArrayList<>();
	        Database db = new Database();
	        try (Connection c = db.connection()) {
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
	            while (rs.next()) {
	                list.add(new Order(
	                    rs.getInt("id"),
	                    rs.getString("items"),
	                    rs.getString("customername"),
	                    rs.getString("status"),
	                    rs.getDate ("created"),
	                    rs.getInt("qty")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return list;
	        }
	        return list;
	    }
	

	@Override
	public Optional<Order> get(int id) {
		return Optional.empty();
	}

	@Override
	public void update(Order entry) {
		   Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("UPDATE orders set status= ? WHERE id=?");
	            pstmt.setString(1, entry.getStatuses()); 
	            pstmt.setInt(2, entry.getId());
	            pstmt.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
	}

	@Override
    public void delete(int id) {
		Database db = new Database();
        try (Connection c = db.connection()){
            PreparedStatement ps = c.prepareStatement("DELETE");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id: " + id + " was deleted from database.");
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}