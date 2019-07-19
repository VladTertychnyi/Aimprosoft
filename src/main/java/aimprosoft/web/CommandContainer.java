package aimprosoft.web;
import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("editDepartment", new EditDepartment());
        commands.put("updateDepartment", new UpdateDepartment());
        commands.put("addWorker", new AddWorker());
        commands.put("GetAllDepartments", new GetAllDepartments());
        commands.put("GetAllWorkersFromDepartment", new GetAllWorkersFromDepartment());
        commands.put("deleteWorker", new DeleteWorker());
        commands.put("addDepartment", new AddDepartment());
        commands.put("deleteDepartment", new DeleteDepartment());
        commands.put("NoCommand", new NoCommand());
        commands.put("GetAllWorkers", new GetAllWorkers());
        commands.put("changeWorker", new ChangeWorkerDepartment());
        commands.put("editWorker", new EditWorkerDepartment());
        commands.put("editWorkerLogin", new EditWorkerLogin());
        commands.put("changeWorkerLogin", new ChangeWorkerLogin());
    }

    public static Command get(String commandName){
        if (commandName == null || !commands.containsKey(commandName)){
            return commands.get("NoCommand");
        }
        return commands.get(commandName);
    }
}
