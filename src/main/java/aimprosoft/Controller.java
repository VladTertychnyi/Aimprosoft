package aimprosoft;

import aimprosoft.exceptions.WebException;
import aimprosoft.web.Command;
import aimprosoft.web.CommandContainer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        String forward = null;
        String commandName = request.getParameter("command");
        System.out.println("used command " + commandName);
        Command command = CommandContainer.get(commandName);
        try {
            forward = command.execute(request, response);
        } catch (WebException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("cause", e.getCause());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher(forward).forward(request, response);
    }
}
