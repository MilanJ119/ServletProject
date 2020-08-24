import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Search extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   out.println("<html>");
   out.println("<head><link rel='stylesheet' href='style2.css'></head>");
   out.println("<body>");
   	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";
        String pass="0119";
		String s1=request.getParameter("rollno");
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
        String q="select * from ins where rollno='"+s1+"'";
        ResultSet rs=st.executeQuery(q);
        RequestDispatcher rd=request.getRequestDispatcher("/Search.html");
        rd.include(request,response);
                    
		
		if(rs.next())
	     {
                 //in both cases we have to show search page SO outside the condition
	    out.println("<br><br><br><br><br><br><br><br><br><br><br>");
	    out.println("<div class='container1'>");
	    out.println("<table class='tab'>");
					out.println("<tr>");
					out.println("<td> Rollno </td>");
	        		out.println("<td>"+rs.getString(1)+"</td>");
	        		out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Name</td>");
	        		out.println("<td>"+rs.getString(2)+"</td>");
	        		out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Physics</td>");
	        		out.println("<td>"+rs.getString(3)+"</td>");
	        		out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Chemistry</td>");
	        		out.println("<td>"+rs.getString(4)+"</td>");
	        		out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Maths</td>");
	        		out.println("<td>"+rs.getString(5)+"</td>");
	        		out.println("</tr>");
            out.println("</table>");
	    out.println("</div>");
	     }
		 else{
                        //RequestDispatcher rd=request.getRequestDispatcher("/Search.html");
                        //rd.include(request,response);
			out.println("<h5 id='Snote'>Invalid RollNo.</h5>");	 
		 }
	    
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
