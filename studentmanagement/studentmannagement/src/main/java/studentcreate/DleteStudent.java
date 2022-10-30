package studentcreate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.model.StudentPojo;
import com.student.dao.StudentImplement;

/**
 * Servlet implementation class DleteStudent
 */
public class DleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		StudentImplement studi=new StudentImplement();
		StudentPojo student=new StudentPojo();
		
		int studentId =Integer.parseInt(request.getParameter("sid"));
		
		String mssage=studi.deleteProduct(studentId);
		
		out.println("<h1 style='color:red'>"+ mssage +"</h1>"); 
		out.println("<a href='vallstudent' style='color:green'>back to the student details</a></td>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
