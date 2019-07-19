package aimprosoft.web;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllWorkers extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
        DaoService daoService = new DaoService();
        List<Worker> workers = daoService.getAllWorkers();
        request.setAttribute("workersList", workers);
        return Path.LIST_OF_WORKERS_PAGE;
    }
}
