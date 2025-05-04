
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "1234");
			String q = "insert into userRegistration(name,email,password) values (?,?,?)";
			psmt = con.prepareStatement(q);
			psmt.setString(1, uname);
			psmt.setString(2, uemail);
			psmt.setString(3, upass);

			int k = psmt.executeUpdate();
			if (k > 0) {
				
//				RequestDispatcher rd = request.getRequestDispatcher("servlet2");
//				rd.forward(request, response);
//				out.print("<h1>Registard successfully</h2>");
				response.sendRedirect("login.html");
			} 
			else {
				out.print("<h1>Registration Faild</h2>");
			}

		} catch (Exception e) {
			 out.print("<h1>Error: " + e.getMessage() + "</h1>");
		}

	}

}
