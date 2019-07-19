package aimprosoft.service;
import aimprosoft.entities.Department;
import aimprosoft.entities.Worker;
import aimprosoft.db.DaoInterface;
import aimprosoft.db.DaoImplementation;
import aimprosoft.exceptions.ServiceException;

import java.util.List;

public class DaoService {

    private DaoInterface daoInterface = new DaoImplementation();


    public void deleteWorker(int id) throws ServiceException {
        daoInterface.deleteWorker(id);
    }


    public void deleteDepartment(int id) throws ServiceException {
        daoInterface.deleteDepartment(id);
    }


    public void updateWorkerDepartment(Worker worker) throws ServiceException {
        daoInterface.updateWorkerDepartment(worker);
    }


    public void updateDepartment(Department department) throws ServiceException {
        daoInterface.updateDepartment(department);
    }

    public List<Worker> getAllWorkers() throws ServiceException{
        return daoInterface.getAllWorkers();
    }


    public void updateWorkerLogin(Worker worker) throws ServiceException{
        daoInterface.updateWorkerLogin(worker);
    }


    public List<Department> getAllDepartments()throws ServiceException {
        return daoInterface.getAllDepartments();
    }


    public List<Worker> getAllWorkersFromDepartment(int departmentId) throws ServiceException{
        return daoInterface.getAllWorkersFromDepartment(departmentId);
    }


    public void addWorker(Worker worker) throws ServiceException{
        daoInterface.addWorker(worker);
    }


    public void addDepartment(Department department)throws ServiceException {
        daoInterface.addDepartment(department);
    }

}
