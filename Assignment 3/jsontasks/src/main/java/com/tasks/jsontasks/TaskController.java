package com.tasks.jsontasks;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/task")
public class TaskController {
    // all postman commands here, 7 in total
    // /task/addtask?Id={}&description={}
    // /task/completeTask?Id={}
    // /task/getTask?Id={}
    // /task/getAllTasks
    // /task/completeTask?Id={}
    // /task/deleteTask?Id={}
    // /task/updateTaskId?Id={}&newId={} 
    // /task/updateTaskDescription?description={} study&Id={}
    TaskService taskService = new TaskService();
    
    @PostMapping("/addTask")
    public String addTask(@RequestParam String Id,@RequestParam String description) {
        return taskService.addTask(Id,description);
    }
    
    @PostMapping("/completeTask")
    public String completeTask(@RequestParam String Id) {
        return taskService.completeTask(Id);
    }

    @PostMapping("/getTask")
    public String getTask(@RequestParam String Id) {
        return taskService.getTask(Id).toString();
    }
    @PostMapping("/getAllTasks")
    public String getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam String Id) {
        return taskService.deleteTask(Id);
    }

    @PostMapping("/updateTaskId")
    public String updateTaskId(@RequestParam String Id, @RequestParam String newId ) {
        return taskService.updateTaskId(Id,newId);
    }

    @PostMapping("/updateTaskDescription")
    public String updateTaskDescription(@RequestParam String Id, @RequestParam String description) {
        return taskService.updateTaskDescription(Id,description);
    }
    


    

    
}
