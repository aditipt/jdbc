package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		connect = DBConfig.getConnect();
		try {
			connect = DBConfig.getConnect();
			stmt = connect.prepareStatement("select * from product where product_name = ? ");
			stmt.setString(1,name);
			//int result =  stmt.executeUpdate();
			//out.print(result + " rows updated<br>");
			
			rs = stmt.executeQuery("select * from product ");
			
			while(rs.next()) {
				
				
//				out.print(rs.getInt(1));
//				out.print("<br>");
//				out.print(rs.getString(2));
//				out.print("<br>");
//				out.print(rs.getInt(3));
//				out.print("<br>");
				
				int id = rs.getInt(1);
				String name1 = rs.getString(2);
				int price = rs.getInt(3);
				String brand = rs.getString(4);
				int number = rs.getInt(5);


				  if(name1.equalsIgnoreCase(name)) {
					
					  out.print("--------Product Details-------");
					  out.print("<br>");
					  out.print("<br>");
					  out.print("Product Id : " + id);
					  out.print("<br>");
					  out.print("Product Name : " + name1);
					  out.print("<br>");
					  out.print("Product Price : " + price + " Rs ");
					  out.print("<br>");
					  out.print("Product Brand : " + brand);
					  out.append("<br>");
					  out.print("No of Items : " + number);
					  out.print("<br>");
					
				}
				  
				
			
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


		finally {
			
			if(connect!=null) {
				
				try {try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt!=null) {
				
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(rs!=null) {
				
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
