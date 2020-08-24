import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogOut extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException
{
   PrintWriter out=response.getWriter();
//   Cookie ck=new Cookie("NAme","");
//   ck.setMaxAge(0);
//   response.addCookie(ck);
HttpSession session=request.getSession();
session.invalidate();
   response.sendRedirect("Login.html");
   out.close();
}

}
