package cs3220.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import cs3220.edu.DAO;
import cs3220.edu.Database;

public class FoodItemDAO implements DAO<FoodItem> {
	
	
	Connection c = null;
    private static final String DELETE = "DELETE FROM food_items WHERE id = ?";
    private static final String UPDATE = "UPDATE food_items SET foodname=?, description=?, imageurl=?, price=?";
    
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("foodname"),
                    rs.getString("description"),
                    rs.getString("imageurl"),
                    rs.getDouble("price")
                ));
            }c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
        return Optional.empty();
    }

    public void add(FoodItem entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO food_items (foodname, description, imageurl, price) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDescription());
            pstmt.setString(3, entry.getImageUrl());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void update(FoodItem entry) {
    	  try {
              PreparedStatement ps = c.prepareStatement(UPDATE);
              ps.setInt(1, entry.getId());
              ps.setString(2, entry.getName());
              ps.setString(3, entry.getDescription());
              ps.setString(3, entry.getImageUrl());
              ps.setDouble(4, entry.getPrice());
              ps.executeUpdate();
              ps.close();
   
              System.out.println("User with id " + entry.getId() + " was updated in database with the following details: " + entry.toString());
   
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id: " + id + " was deleted from database.");
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
