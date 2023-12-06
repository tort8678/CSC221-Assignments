package com.tasks.jsontasks;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

interface TaskRepositoryInterface{
    public String addTask(Task t); // add task to list 
    public boolean completeTask(String Id); //flip the complete boolean for a task
    public Task getTask(String Id); //return all fields of task matching id
    public String getAllTasks(); //return all tasks in JSON form
    public int taskIndex(String Id); //return index of a task if it exists, else return -1
    public boolean deleteTask(String Id); //delete task with matching id
    public String updateTaskId(String Id, String newId); //update the task with matching id to newId
    public String updateTaskDescription(String Id, String des); // update the description of task with match id
    public JSONObject toJSON(int ind); //convert the task at index ind to json and return that object
    // private void writeJSON(); write all tasks in tasklist to a json file, excutes after each change

}

public class TaskRepository implements TaskRepositoryInterface{
    private ArrayList<Task> taskList = new ArrayList<Task>();
    // read json file if it exists and populate task list
    public TaskRepository(){  
        try{
            InputStream input = new FileInputStream("./output.json");
            String jsonTxt = IOUtils.toString(input,"UTF-8");
            JSONArray json = new JSONArray(jsonTxt);    
            for(int i =0; i < json.length(); i++){
                JSONObject obj = json.getJSONObject(i);
                taskList.add(new Task(obj));
            }
            input.close();
            System.out.println("File read successfully");

        }catch(Exception e){
            System.out.println("ERROR READING FILE\n" +e);
        }
    }
    
    public String addTask(Task t){
        if(taskIndex(t.getId()) == -1) {
            taskList.add(t);
            writeJSON();
            return "Task added!";
        } else return "Task Id already exists!";

    }

    public boolean completeTask(String Id){
        boolean complete = false;
        for(Task current:taskList){
            if(current.getId().equals(Id)){
                complete = true;
                current.completeTask();
                writeJSON();
                break;
            }
        }

        return complete;
    }

    public Task getTask(String Id){
        Task out = new Task();
        for(Task current:taskList){
            if(current.getId().equals(Id)){
                out = current;
                break;
            }
        }
        return out;
    }

    public int taskIndex(String Id){
        for(int i = 0; i < taskList.size();i++){
            if(taskList.get(i).getId().equals(Id)) return i;
        }
        return -1;
    }

    public boolean deleteTask(String Id){
        boolean complete = false;
        for(int i = 0; i < taskList.size();i++){
            if(taskList.get(i).getId().equals(Id)){
                complete = true;
                taskList.remove(i);
                writeJSON();
                break;
            }
        }
        return complete;
    }

    public String updateTaskId(String Id, String newId){
        int index = taskIndex(Id);
        if(index == -1) return "Task does not exist";
        else if(taskIndex(newId) > -1) return "Task exists, but new Task id is taken."; 
        else {
            taskList.get(index).setId(newId);
            writeJSON();
        }

        return "Successfully changed task " + Id + " to "+ newId;
    }

    public String updateTaskDescription(String Id, String desc){
        int index = taskIndex(Id);
        if(index == -1) return "Task does not exist";
        else{
            taskList.get(index).setDescription(desc);
            writeJSON();
        }
        return "Successfully changed description of " + Id;
    }

    public String getAllTasks(){
        String tasks = "";
        for(Task t:taskList){
            tasks = tasks.concat(t.toJSON().toString()+ ",\n");
        }
        return tasks;
    }

    public JSONObject toJSON(int ind){
        return taskList.get(ind).toJSON();
    }

    private void writeJSON(){
        try{
            FileWriter file = new FileWriter("./output.json");
            file.write("[\n");
             for(int i = 0; i < taskList.size();i++){
                if(i == taskList.size()-1)
                    file.write(taskList.get(i).toJSON().toString(2));
                else file.write(taskList.get(i).toJSON().toString(2)+",\n");

            }
            file.write("\n]");
            file.close();
        } catch(Exception e){
            System.out.println("ERROR OCCURRED\n"+e);
        }
    }
    

}
