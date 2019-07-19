package aimprosoft.web;
import aimprosoft.entities.Department;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditWorkerDepartment extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
        Worker worker = new Worker();
        DaoService daoService = new DaoService();
        worker.setId(Integer.parseInt(request.getParameter("curWorker_id")));
        worker.setDepartment_id(Integer.parseInt(request.getParameter("newDepartmentId")));
        daoService.updateWorkerDepartment(worker);
       List<Department> departments = daoService.getAllDepartments();
        request.setAttribute("departmentsList", departments);
        return Path.LIST_OF_DEPARTMENTS_PAGE;
    }
}
