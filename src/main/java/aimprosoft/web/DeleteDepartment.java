package aimprosoft.web;
import aimprosoft.entities.Department;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteDepartment extends Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws WebException {
        DaoService daoService = new DaoService();
        int department_id = Integer.parseInt(req.getParameter("curDepartment_id"));
        int defaultDepartment = Integer.parseInt(req.getParameter("defaultDepartment"));
        if (department_id != 999) {
            List<Worker> allWorkersFromDepartment = daoService.getAllWorkersFromDepartment(department_id);
            if (allWorkersFromDepartment.isEmpty()) {
                daoService.deleteDepartment(department_id);
            } else {
                for (Worker w : allWorkersFromDepartment) {
                    w.setDepartment_id(defaultDepartment);
                    daoService.updateWorkerDepartment(w);
                }
                daoService.deleteDepartment(department_id);
            }
            List<Department> departments = daoService.getAllDepartments();
            req.setAttribute("departmentsList", departments);
            return Path.LIST_OF_DEPARTMENTS_PAGE;
        } else {
            return Path.HI_PAGE;
        }
    }
}