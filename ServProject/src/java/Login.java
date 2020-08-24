//set classpath=C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar;.;%classpath%
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
   String s1=request.getParameter("email");
   String s2=request.getParameter("pass");
   out.println("<html>");
   out.println("<head><link rel='stylesheet' href='style2.css'></head>");
   out.println("<body>");
  	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Serv";
        String name="root";	
        String pass="0119";
        Connection con=DriverManager.getConnection(url,name,pass);	
	    Statement st=con.createStatement();
        String q="select * from login where email='"+s1+"' AND password='"+s2+"'";
        ResultSet rs=st.executeQuery(q);
	    if(rs.next())
	    {
//                Cookie ck=new Cookie("NAme",s1);
//                ck.setMaxAge(60*60);
//                response.addCookie(ck);
                HttpSession session=request.getSession();
                session.setAttribute("n",s1);
                response.sendRedirect("Menu");
	    }
            else{
                RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
                rd.include(request,response);
                out.println("<h5 id='Lnote'>Incorrect email or password.</h5>");
		 }
	    
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
