
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "shreyas"),
                @WebInitParam(name = "password", value = "shre11")
        }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        if(!isValidName(user)){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter output = response.getWriter();
            output.println("<font color=red>User name is not correct .</font>");
            requestDispatcher.include(request, response);
            return;
        }
        String pwd = request.getParameter("pwd");
        if(!isValidPassword(pwd)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter output = response.getWriter();
            output.println("<font color=red>Password is not correct .</font>");
            rd.include(request, response);
            return;
        }

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        if(userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter output = response.getWriter();
            output.println("<font color=red>Either user name or password is wrong.</font>");
            requestDispatcher.include(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    boolean isValidName(String element){
        String regex = "[A-Z]{1}[a-z]{2,}";
        return Pattern.matches(regex,element );
    }

    boolean isValidPassword(String element){
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*.!@#$%^&(){}:;<>?/~_+-=|\\]]).{8,}";
        return Pattern.matches(regex,element);
    }

}