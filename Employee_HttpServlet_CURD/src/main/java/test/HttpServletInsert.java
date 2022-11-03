package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class HttpServletInsert extends HttpServlet
{
	public EmployeeBean eb=null;
	public InsertDAO  ob=null;
 public void init()throws ServletException
 {
	 eb=new EmployeeBean();
	 ob=new InsertDAO();
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
	 eb.setId(req.getParameter("id"));
	 eb.setName(req.getParameter("name"));
	 eb.setDesg(req.getParameter("desg"));
	 eb.setbSal(Integer.parseInt(req.getParameter("bsal")));
	 int bsal=Integer.parseInt(req.getParameter("bsal"));
	 eb.settSal(bsal+(0.93F*bsal)+(0.63F*bsal));
	 int k=ob.insert(eb);
	 if(k>0)
	 {
		 pw.println("Mr.."+name);
		 pw.println("Record Inserted SuccessFully.....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 pw.println("There is something Problem.....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
		 rd.include(req, res);
	 }
	 }
 }
 public void destroy()
 {
	 ob=null;
	 eb=null;
 }
}
