package aimprosoft.web;
import aimprosoft.entities.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeWorkerLogin extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        Worker worker = new Worker();
        worker.setId(Integer.parseInt(request.getParameter("curWorker_id")));
        int dep_id = Integer.parseInt(request.getParameter("curWorkerDepartment_id"));
        request.setAttribute("curWorkerDepartment_id", dep_id);
        request.setAttribute("curWorker_id", worker.getId());
        return Path.UPDATE_WORKER_LOGIN;
    }
}
