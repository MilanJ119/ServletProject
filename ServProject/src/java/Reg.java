import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Reg extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   String s1=request.getParameter("Fname");
   String s2=request.getParameter("Lname");
   String s3=request.getParameter("email");
   String s4=request.getParameter("pass");
   String s5=request.getParameter("Mob");
   out.println("<html>");
   out.println("<body>");
  	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";	
        String pass="0119";
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
        String q="insert into login values('"+s3+"','"+s4+"')";
        st.executeUpdate(q);
		String q1="insert into reg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
        st.executeUpdate(q1);
	    
        
		response.sendRedirect("Login.html");
	    
		con.close();
	    
		
	    }
        catch(Exception ex)
        {
	     out.println(ex);
		}	
		out.println("</body>");
        out.println("</html>");
        out.close();
}

}
