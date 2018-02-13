package cs3220.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs3220.edu.Order.Statuses;

@WebServlet("/CustomerMenuServlet")
public class CustomerMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> entries = (List<FoodItem>) request.getSession().getAttribute("entries");
		if (entries == null) {
			entries = new ArrayList<>();
			entries.add(new FoodItem(entries.size(), "Ginger Sesame Glazed Salmon", 
					"The salmon is sliced and marinated, then cooked in sesame oil. Served with sauce on the side and chopped "
					+ "fresh cilantro sprinkled on top. Garnished with black sesame seeds.", 
					"https://cdn4.ruled.me/wp-content/uploads/2014/05/SoySearedSalmon.jpg", 20.00));
			entries.add(new FoodItem(entries.size(), "Hasselback Marinara Chicken", "The chicken breasts are sliced accordion style "
					+ "and stuffed with spinach and cheeses. Topped with tomato sauce and mozzarella.",
					"https://cdn4.ruled.me/wp-content/uploads/2017/03/IMG_1166.jpg", 18.00));
			entries.add(new FoodItem(entries.size(), "Nacho Steak Skillet", "This nacho steak skillet features roasted cauliflower, "
					+ "thin sliced steak, cheese, and lots of fun nacho toppings.",
					"https://cdn4.ruled.me/wp-content/uploads/2017/05/featured1.jpg", 16.00));
		}
		String deletedRecipeName=request.getParameter("Submit");
		if(deletedRecipeName!=null)
		{
			for (Iterator<FoodItem> iter = entries.listIterator(); iter.hasNext(); ) {
			    FoodItem item = iter.next();
			    if (item.getName().equals(deletedRecipeName)) {
			        iter.remove();
			    }
			}
		}
		
		request.getSession(true).setAttribute("items", entries);
		request.getSession().setAttribute("date", new Date());
		request.getRequestDispatcher("./WEB-INF/index.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		List<FoodItem> entries = (List<FoodItem>) request.getSession().getAttribute("entries");
		List<Order> orderEntries = new ArrayList<>();

		for(int i = 0; i < entries.size(); i++)
		{
			int qty = Integer.parseInt(request.getParameter("fooditem_id"+i));
			
			if(qty > 0)
			{
				FoodItem leEntry = null;
				int foodItemId = Integer.parseInt(request.getParameter("fid"+i));
				for (FoodItem entry: entries) {
					if (entry.getId() == foodItemId) {
						leEntry = entry;
					}
				}

				orderEntries.add(new Order(orderEntries.size(),leEntry.toString(),"Bryce", Statuses.IN_QUEUE.toString(),new java.util.Date(System.currentTimeMillis()),qty));
			}
		}
		getServletContext().setAttribute("orderEntries", orderEntries);
		response.sendRedirect("./order");	
	}	
}