package aimprosoft.web;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.WebException;
import aimprosoft.service.DaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class AddWorker extends Command  {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        DaoService daoService = new DaoService();
        Worker worker = new Worker();
        worker.setId(Integer.parseInt(request.getParameter("curWorker_id")));
        worker.setLogin(request.getParameter("login"));
        worker.setMail(request.getParameter("mail"));

//        dateFormat.format(Date.request.getParameter("bdate"));

        worker.setDate(Date.valueOf(request.getParameter("bdate")));
        worker.setDepartment_id(Integer.parseInt(request.getParameter("depIdOfCurWorker")));
        daoService.addWorker(worker);
        List<Worker> workers = daoService.getAllWorkers();
        request.setAttribute("workersList", workers);
        return Path.LIST_OF_WORKERS_PAGE;
    }
}
