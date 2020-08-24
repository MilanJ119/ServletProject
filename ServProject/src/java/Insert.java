import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insert extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   
   String s1=request.getParameter("rollno");
   String s2=request.getParameter("name");
   String s3=request.getParameter("phy");
   String s4=request.getParameter("chem");
   String s5=request.getParameter("maths");
   
   out.println("<html>");
   out.println("<body>");
  	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";	
        String pass="0119";
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
        String q="insert into ins values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
        st.executeUpdate(q);
	    
		response.sendRedirect("Insert.html");
		
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
