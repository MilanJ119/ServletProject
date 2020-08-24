import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Delete extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   out.println("<html>");
   out.println("<head><link rel='stylesheet' href='style2.css'></head>");
   out.println("<body>");
   
                try{
			String s1=request.getParameter("rollno");
			String url="jdbc:mysql://localhost:3306/Serv";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Delete from ins where rollno='"+s1+"'";
			st.executeUpdate(q);
			response.sendRedirect("Delete.html");
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
   	
		out.println("</body>");
        out.println("</html>");
        out.close();
}

}
