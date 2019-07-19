package aimprosoft.web;
import aimprosoft.entities.Department;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDepartment extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (Integer.parseInt(request.getParameter("curDepartment_id")) != 999) {
            Department department = new Department();
            department.setId(Integer.parseInt(request.getParameter("curDepartment_id")));
            request.setAttribute("curDepartment_id", department.getId());
            return Path.UPDATE_DEPARTMENT;
        } else {
            return Path.HI_PAGE;
        }
    }
}