package aimprosoft.web;
import aimprosoft.entities.Department;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditDepartment extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
        DaoService daoService = new DaoService();
        Department department = new Department();
        department.setId(Integer.parseInt(request.getParameter("curDepartment_id")));
        department.setName(request.getParameter("name"));
        daoService.updateDepartment(department);
        List<Department> departments = daoService.getAllDepartments();
        request.setAttribute("departmentsList", departments);
        return Path.LIST_OF_DEPARTMENTS_PAGE;
    }
}
