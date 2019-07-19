package aimprosoft.db;
import aimprosoft.entities.Department;
import aimprosoft.entities.Worker;
import aimprosoft.exceptions.DBException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DaoImplementation implements DaoInterface {

    private Connection connection;

    private void closeConnection() throws DBException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage(), e.getCause());
            }
        }
    }


    public List<Department> getAllDepartments() throws DBException {
        List<Department> departments = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(RequestDB.SELECT_ALL_DEPARTMENTS)) {
            connection = ConnectionPool.getConnection();
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getInt("department_id"),
                        resultSet.getString("department_name")));
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
        return departments;
    }


    public List<Worker> getAllWorkersFromDepartment(int departmentId) throws DBException {
        List<Worker> workers = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(RequestDB.SELECT_ALL_WORKERS_FROM_DEPARTMENT)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(1, departmentId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                workers.add(new Worker
                        (resultSet.getInt("worker_id"),
                                resultSet.getString("worker_login"),
                                resultSet.getString("worker_mail"),
                                resultSet.getDate("worker_bdate"),
                                resultSet.getInt("worker_department_id")));
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
        return workers;
    }


    public void addWorker(Worker worker) throws DBException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(RequestDB.ADD_WORKER)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(1, worker.getId());
            preparedStatement.setString(2, worker.getLogin());
            preparedStatement.setString(3, worker.getMail());
            preparedStatement.setDate(4, (Date) worker.getDate());
            preparedStatement.setInt(5, worker.getDepartment_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }


    public void addDepartment(Department department) throws DBException {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(RequestDB.ADD_DEPARTMENT)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }

    public void deleteWorker(int id) throws DBException {
        try {
            connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(RequestDB.DELETE_WORKER + id);
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }

    public void deleteDepartment(int id) throws DBException {
        try {
            connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(RequestDB.DELETE_DEPARTMENT + id);
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }

    public void updateWorkerDepartment(Worker worker) throws DBException {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(RequestDB.UPDATE_WORKER_DEPARTMENT)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(2, worker.getId());
            preparedStatement.setInt(1, worker.getDepartment_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }


    public void updateWorkerLogin(Worker worker) throws DBException {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(RequestDB.UPDATE_WORKER_LOGIN)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(2, worker.getId());
            preparedStatement.setString(1, worker.getLogin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }


    public void updateDepartment(Department department) throws DBException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(RequestDB.UPDATE_DEPARTMENT)) {
            connection = ConnectionPool.getConnection();
            preparedStatement.setInt(2, department.getId());
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Worker> getAllWorkers() throws DBException {
        List<Worker> workers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(RequestDB.SELECT_ALL_WORKERS)) {
            while (resultSet.next()) {
                workers.add(new Worker(
                                resultSet.getInt("worker_id"),
                                resultSet.getString("worker_login"),
                                resultSet.getString("worker_mail"),
                                resultSet.getDate("worker_bdate"),
                                resultSet.getInt("worker_department_id")
                        )
                );
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e.getCause());
        } finally {
            closeConnection();
        }
        return workers;
    }
}
