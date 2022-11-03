package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class AdminLogInHTTPServlet extends HttpServlet
{
	public AdminDAO ob=null;
	public AdminBean ab=null;
 public  void init()throws ServletException
 {
	 ob=new AdminDAO();
	 ab=new AdminBean();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 ab=new AdminDAO().adminCheck(req);
	 if(ab==null)
	 {
		 pw.println("Incorrect UserName/PassWord.......<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 Cookie ck=new Cookie("fName",ab.getfName());
		 res.addCookie(ck);
		 pw.println("Welcome Mr."+ab.getfName()+"....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
		 rd.include(req, res);
		 
	 }
 }
 public void destry()
 {
	 ob=null;
	 ab=null;
 }
}
