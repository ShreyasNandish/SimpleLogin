import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hello")
public class SimpleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        output.println("<h1> Hello World this is shreyas here!!</h1>");
        output.close();
    }
}
