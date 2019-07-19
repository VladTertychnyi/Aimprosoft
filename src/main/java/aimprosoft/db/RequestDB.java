package aimprosoft.db;
public class RequestDB {

    public static final String SELECT_ALL_DEPARTMENTS = "SELECT *FROM department";
    public static final String SELECT_ALL_WORKERS = "SELECT *FROM worker";
    public static final String SELECT_ALL_WORKERS_FROM_DEPARTMENT = "SELECT *FROM worker WHERE worker_department_id = ?";
    public static final String ADD_WORKER = "INSERT INTO worker (worker_id, worker_login, worker_mail, worker_bdate, worker_department_id) VALUES (?,?,?,?,?)";
    public static final String ADD_DEPARTMENT = "INSERT INTO department (department_id, department_name) VALUES (?,?)";
    public static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE department_id = ";
    public static final String DELETE_WORKER = "DELETE FROM worker WHERE worker_id = ";
    public static final String UPDATE_WORKER_LOGIN = "UPDATE worker SET worker_login=? WHERE worker_id=?";
    public static final String UPDATE_WORKER_DEPARTMENT = "UPDATE worker SET worker_department_id=? WHERE worker_id=?";
    public static final String UPDATE_DEPARTMENT = "UPDATE department SET department_name=? WHERE department_id=?";
}
