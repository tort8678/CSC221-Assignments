package com.tasks.jsontasks;
import org.json.JSONObject;

//connects task repository to task controller
public class TaskService {
    TaskRepository taskRepository = new TaskRepository();

    public String addTask(String Id, String description){
        return taskRepository.addTask(new Task(Id,description));
        
    }

    public JSONObject getTask(String Id){
        int ind = taskRepository.taskIndex(Id);
        if(ind >= 0) return taskRepository.toJSON(ind);
        else return new JSONObject();
    }

    public String getAllTasks(){
       return taskRepository.getAllTasks();
    }

    public String completeTask(String Id){
        boolean complete = taskRepository.completeTask(Id);
        if(complete) return "task completed";
        else return "task not found!";
    }

    public String deleteTask(String Id){
        boolean complete = taskRepository.deleteTask(Id);
        if(complete) return "task deleted";
        else return "task not found!";
    }

    public String updateTaskId(String Id, String newId){
        return taskRepository.updateTaskId(Id, newId);

    }

    public String updateTaskDescription(String Id, String desc){
        return taskRepository.updateTaskDescription(Id, desc);
    }

    
}
