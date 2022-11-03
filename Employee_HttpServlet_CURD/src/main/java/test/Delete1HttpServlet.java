package test;
import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/deleteid")
public class Delete1HttpServlet extends HttpServlet
{
	public VerifyDAO vd=null;
	public DeleteDAO dd=null;
	public EmployeeBean eb=null;
 public void init()throws ServletException
 {
	 vd=new VerifyDAO();
	 dd=new DeleteDAO();
	 eb=new EmployeeBean();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session Expired Login Again....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 String name=ck[0].getValue();
		 pw.println("Mr.."+name+"<br>");
		 eb=vd.verify(req);
		 if(eb==null)
		 {
			 pw.println("There is No Record On This Id Sir/Madam....<br>");
			 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
			 rd.include(req, res);
		 }
		 else
		 {
			 int k=dd.delete(eb);
			 if(k>0)
			 {
				 pw.println("Employee Deleted SuccessFully Sir/Madam....<br>");
			 }
			 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
			 rd.include(req, res);
		 }
	 }
 }
 public void destroy()
 {
	 vd=null;
	 dd=null;
	 eb=null;
	 
 }
}
