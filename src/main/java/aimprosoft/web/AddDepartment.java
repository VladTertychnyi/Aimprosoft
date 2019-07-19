package aimprosoft.web;
import aimprosoft.entities.Department;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class AddDepartment extends Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws WebException {
        DaoService daoService = new DaoService();
        Department department = new Department();
        department.setId(Integer.parseInt(req.getParameter("curDepartment_id")));
        department.setName(req.getParameter("name"));
        daoService.addDepartment(department);
        Collection<Department> departments = daoService.getAllDepartments();
        req.setAttribute("departmentsList", departments);
        return Path.LIST_OF_DEPARTMENTS_PAGE;
    }
}
