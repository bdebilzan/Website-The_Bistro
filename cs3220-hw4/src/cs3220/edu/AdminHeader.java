package cs3220.edu;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<img src = 'https://logopond.com/logos/936fb12d35d4bb7f4f9d6c3085caa4e4.png' width= '180' height='180'> <b>The Bistro - Admin</b>" );
		out.println(
				"<br><a href='http://localhost:8080/cs3220-hw3/RestaurantAdminServlet'> Inventory </a>|<a href='http://localhost:8080/cs3220-hw3/AdminCreateFoodServlet'> Create Food </a>|<a href='http://localhost:8080/cs3220-hw3/AdminStatusesServlet'> Statuses</a> ");
		out.println("|<a href='http://localhost:8080/cs3220-hw3/CustomerMenuServlet'> (View Customer Side) </a>");
	}
}