package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class RerieveHttpServlet extends HttpServlet
{
	public ArrayList<EmployeeBean> al=null;
	public RetrieveDAO ob=null;
 public void init()throws ServletException
 {
	 al=new ArrayList<EmployeeBean>();
	 ob=new RetrieveDAO();
 }
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session expired Login Again......<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 String fName=ck[0].getValue();
		 pw.println("Mr..."+fName+"<br>");
		 al=ob.view();
		 if(al.isEmpty())
		 {
			 pw.println("No Records Found......<br>");
		 }
		 else
		 {
			 Spliterator<EmployeeBean> sp=al.spliterator();
			 pw.println("<table border='5' align='center'  style='width:500px;'>");
			 pw.println("<caption>Employees Details</caption>");
                   pw.println("<th>Employee Id</th>");
                   pw.println("<th>Employee Name</th>");
                   pw.println("<th>Employee Desg</th>");
                   pw.println("<th>Employee BSal</th>");
                   pw.println("<th>Employee TSal</th>");
			 sp.forEachRemaining((k)->
			 {
				 EmployeeBean eb=(EmployeeBean)k;
				 pw.println("<tr>");
				 pw.println("<td>"+eb.getId()+"</td>");
				 pw.println("<td>"+eb.getName()+"</td>");
				 pw.println("<td>"+eb.getDesg()+"</td>");
				 pw.println("<td>"+eb.getbSal()+"</td>");
				 pw.println("<td>"+eb.gettSal()+"</td>");
				 pw.println("</tr>");
			 }
			 );
			 pw.println("</table>");
		 }
		 RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
		 rd.include(req, res);
	 }
 }
 public void destroy()
 {
	 al=null;
	 ob=null;
 }
}
