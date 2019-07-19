package aimprosoft.web;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteWorker extends Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws WebException {
        int worker_id = Integer.parseInt(req.getParameter("curWorker_id"));
        DaoService daoService = new DaoService();
        daoService.deleteWorker(worker_id);
        List<Worker> workers = daoService.getAllWorkers();
        req.setAttribute("workersList", workers);
        return Path.LIST_OF_WORKERS_PAGE;
    }
}
