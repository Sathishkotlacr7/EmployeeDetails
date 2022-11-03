package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogOutHttpServlet extends HttpServlet
{
 public void init()throws ServletException
 {
	 //No-code
 }
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie c[]=req.getCookies();
	 if(c==null)
	 {
		 pw.println("Session Expired.....LogIn again..<br>");
	 }
	 else
	 {
		 c[0].setMaxAge(0);
		 pw.println("Admin Loged Out SuccessFully....<br>");
	 }
	 RequestDispatcher rd=req.getRequestDispatcher("login.html");
	 rd.include(req, res);
 }
 public void detroy()
 {
	 //no_Code
 }
}
