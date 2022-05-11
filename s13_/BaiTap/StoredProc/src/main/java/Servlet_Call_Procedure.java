import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "Servlet_Call_Procedure", urlPatterns = "/user")
public class Servlet_Call_Procedure extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Bai_12";
    private String jdbcUsername = "project";
    private String jdbcPassword = "123456";
    private Connection connection;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        call_Procedure(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void call_Procedure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String runSP = "{ call create_procedure(?,?,?) }";
            CallableStatement callableStatement= connection.prepareCall(runSP);
            callableStatement.setString(1, "Tuan");
            callableStatement.setString(2, "tuan123@gmail.com");
            callableStatement.setString(3, "Viet Nam");
            callableStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}