import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ShowAll extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   out.println("<html>");
   out.println("<head><link rel='stylesheet' href='style2.css'></head>");
   out.println("<body>");
   
   out.println("<nav id='navbar'>");
       out.println(" <ul class='ForTwoOnly'>");
            out.println("<li><a href='Menu'>Home</a></li>");
            out.println("<li><a href='Search.html'>Search</a></li>");
            out.println("<li><a href='Insert.html'>Insert</a></li>");
            out.println("<li><a href='Update.html'>Update</a></li>");
            out.println("<li><a href='Delete.html'>Delete</a></li>");
            out.println("<li><a href='ShowAll'>ShowAll</a></li>");
            out.println("<li><a href='LogOut'>LogOut</a></li>");
        out.println("</ul>");
    out.println("</nav>");
  
   



  	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";
        String pass="0119";
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
        String q="select * from ins";
        ResultSet rs=st.executeQuery(q);
	    out.println("<div class='container'>");
	    out.println("<table class='tab'>");
		out.println("<tr>");
		out.println("<td> Rollno </td>");
		out.println("<td> Name</td>");
		out.println("<td> Physics</td>");
		out.println("<td> Chemistry</td>");
		out.println("<td> Maths</td>");
		
		while(rs.next())
	     {
	        		out.println("<tr>");
	        		out.println("<td>"+rs.getString(1)+"</td>");
	        		out.println("<td>"+rs.getString(2)+"</td>");
	        		out.println("<td>"+rs.getString(3)+"</td>");
	        		out.println("<td>"+rs.getString(4)+"</td>");
	        		out.println("<td>"+rs.getString(5)+"</td>");
	        		out.println("</tr>");
	     }
	    
		out.println("</table>");
	    out.println("</div>");
	    con.close();
	    }
        catch(Exception e1)
        {
	     out.println(e1);
		}	
		out.println("</body>");
        out.println("</html>");
        out.close();
}

}
