import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Menu extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
//   Cookie ck[]=request.getCookies();
//   if(ck!=null)
    HttpSession session=request.getSession();
    String s0=(String)session.getAttribute("n");
    if(s0!=null)
   {
   out.println("<html>");
   out.println("<head><link rel='stylesheet' href='style2.css'></head>");
   
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
    out.println("<body>");
//To get user_name from registration      
        try{
//            String s1=ck[0].getValue();
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";	
        String pass="0119";
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
//        String q="select * from reg where email='"+s1+"'";
        String q="select * from reg where email='"+s0+"'";
        ResultSet rs=st.executeQuery(q);
	    if(rs.next())
	    {
                String s2=rs.getString(1);
    out.println("<div class='menu'>Welcome&nbsp"+s2+'!'+"</div>");
               
	    }
            else{
                RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
                rd.include(request,response);
		 }
	    
	    con.close();
	    }
        catch(Exception ex)
        {	
	     out.println(ex);
        }
        
        out.println("</body>");
        out.println("</html>");
        }
   else{
   response.sendRedirect("Login.html");
   }
    out.close();
}

}
