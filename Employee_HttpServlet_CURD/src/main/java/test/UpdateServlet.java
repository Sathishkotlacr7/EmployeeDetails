package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	public EmployeeBean eb=null;
	public VerifyDAO ob=null;
 public void init()throws ServletException
 {
	 eb=new EmployeeBean();
	 ob=new VerifyDAO();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck.length==0)
	 {
		 pw.println("Session Expired Login again.....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 String s=ck[0].getValue();
		 pw.println("Mr..."+s+"<br>");
		 eb=ob.verify(req);
		 if(eb==null)
		 {
			 pw.println("Record Not Found On this EmployeeId....<br>");
			 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
			 rd.include(req, res);
		 }
		 else
		 {
			 pw.println("<form action='update1' method='post'>");
			 pw.println("<input type='hidden' name='id' value='"+eb.getId()+"'<br>");
			 pw.println("Enter EmpName:<input type='text' name='name' value='"+eb.getName()+"'<br>");
			 pw.println("Enter EmpDesg:<input type='text' name='desg' value='"+eb.getDesg()+"'<br>");
			 pw.println("Enter EmpBSal:<input type='text' name='bsal' value='"+eb.getbSal()+"'<br>");
			 pw.println("<input type='submit' value='Update'>");
			 pw.println("</form>");
		 }
	 }
 }
 public void destry()
 {
	 eb=null;
	 ob=null;
 }
}
