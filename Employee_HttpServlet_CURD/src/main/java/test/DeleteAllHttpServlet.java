package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteAllHttpServlet extends HttpServlet
{
	public DeleteAllDAO da=null;
 public void init()throws ServletException
 {
	 da=new DeleteAllDAO();
 }
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session Expird LogIn Again....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 int k=da.deleteAll();
		 String name=ck[0].getValue();
		 pw.println("Mr..."+name+"<br>");
		 if(k>0)
		 {
			 pw.println("Deleted SuccessFully....<br>");
			 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
			 rd.include(req, res);
		 }
		 else
		 {
			 pw.println("No Records There For Delete....<br>");
			 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
			 rd.include(req, res);	 
		 }
		
	 }
 }
 public void destroy()
 {
	 
 }
}
