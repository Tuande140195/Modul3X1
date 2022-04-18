import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChietKhauServlet", value = "/tinhchietkhau")
public class ChietKhauServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String mota = request.getParameter("mota");
        Double giagoc = Double.parseDouble(request.getParameter("gia"));
        Double chietkhau = Double.parseDouble(request.getParameter("chietkhau"));

        Double giasauchietkhau = giagoc * chietkhau/100;

        PrintWriter writer = response.getWriter();

        writer.println("<h1>"+ mota + "</h1>"+"<br/>");
        writer.println( "Lượng chiết khấu: "+ chietkhau +"% <br/>");
        writer.println("Giá sau chiết khấu: " + giasauchietkhau );
    }
}
