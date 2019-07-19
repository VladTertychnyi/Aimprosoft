package aimprosoft.web;
import aimprosoft.entities.Department;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class GetAllDepartments extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
        DaoService daoService = new DaoService();
        Collection<Department> departments = daoService.getAllDepartments();
        request.setAttribute("departmentsList", departments);
        return Path.LIST_OF_DEPARTMENTS_PAGE;
    }
}
