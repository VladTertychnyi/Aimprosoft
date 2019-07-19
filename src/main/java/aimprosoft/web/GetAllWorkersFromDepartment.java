package aimprosoft.web;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllWorkersFromDepartment extends Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)throws WebException {
        int departmentId = Integer.parseInt(req.getParameter("curDepartment_id"));
        DaoService daoService = new DaoService();
        List<Worker> workersByDepartment = daoService.getAllWorkersFromDepartment(departmentId);
        req.setAttribute("workersList", workersByDepartment);
        return Path.LIST_OF_WORKERS_PAGE;
    }
}
