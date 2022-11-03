package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/update1")
public class Update2HttpServlet extends HttpServlet
{
 public UpdateDAO ud=null;
 public EmployeeBean eb=null;
 public void init()throws ServletException
 {
	 ud=new UpdateDAO();
	 eb=new EmployeeBean();
 }
 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session Expired Login again....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 String s=ck[0].getValue();
		 pw.println("Mr"+s+"<br>");
		 eb.setId(req.getParameter("id"));
		 eb.setName(req.getParameter("name"));
		 eb.setDesg(req.getParameter("desg"));
		 int b=Integer.parseInt(req.getParameter("bsal"));
		 Float tsal=b+(0.93F*b)+(0.63F*b);
		 eb.setbSal(b);
		 eb.settSal(tsal);
		 int k=ud.update(eb);
		 if(k>0)
		 {
			 pw.println("Updated Successfully....<br>");
			
		 }
		 else
		 {
			 pw.println("Not Updated ...<br>");
		 }
		 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
		 rd.include(req, res);
	 }
 }
 public void destroy()
 {
	 
 }
}
