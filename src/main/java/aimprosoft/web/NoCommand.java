package aimprosoft.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Path.HI_PAGE;
    }
}
