package com.tasks.jsontasks;
import org.json.JSONObject;

public class Task {
    private String Id;
    private String description;
    private boolean completed;
    //new task creations use this constructor
    public Task(String Id, String description){
        this.Id = Id;
        this.description = description;
        completed = false;
    }
    //base constructor just in case
    public Task(){
        Id = "";
        description = "";
        completed = false;
    }
    //task constructor using JSONObject from file, used when reading file
    public Task(JSONObject input){
        try{
            Id = (String)input.getString("Id");
            description = (String)input.getString("description");
            completed = (boolean)input.getBoolean("completed");
        } catch(Exception e){
            System.out.println("JSON object has incorrect fields!");
        }
    }
    // flip the completed boolean
    public void completeTask(){
        completed = !completed;
    }
    //getters and setters
    public String getId(){return Id;}
    public void setId(String id){Id = id;}
    public String getDescription(){return description;}
    public void setDescription(String desc){description = desc;}
    //convert a task to json object format 
    public JSONObject toJSON(){
        JSONObject out = new JSONObject();
        out.put("Id", Id);
        out.put("description",description);
        out.put("completed", completed);
        return out;
    }
    
}
