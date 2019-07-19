package aimprosoft.db;

import aimprosoft.entities.Department;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.DBException;

import java.util.List;

public interface DaoInterface {

//    void add(Entity entity) throws DBException;
//
//    List<Entity> getAll() throws DBException;




    List<Department> getAllDepartments() throws DBException;

    List<Worker> getAllWorkersFromDepartment(int departmentId) throws DBException;

    void addWorker(Worker worker) throws DBException;

    void deleteWorker (int id) throws DBException;

    void addDepartment (Department department) throws DBException;

    void deleteDepartment(int id) throws DBException;

    void updateWorkerDepartment(Worker worker) throws DBException;

    void updateDepartment(Department department) throws DBException;

    List<Worker> getAllWorkers() throws DBException;

    void updateWorkerLogin(Worker worker) throws DBException;
}
