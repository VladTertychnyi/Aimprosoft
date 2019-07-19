package aimprosoft.web;
import aimprosoft.entities.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeWorkerDepartment extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        Worker worker = new Worker();
        worker.setId(Integer.parseInt(request.getParameter("curWorker_id")));
        int departmentId = Integer.parseInt(request.getParameter("curWorkerDepartment_id"));
        request.setAttribute("curWorker_id", worker.getId());
        request.setAttribute("curWorkerDepartment_id", departmentId);
        return Path.UPDATE_WORKER_DEPARTMENT;
    }
}
