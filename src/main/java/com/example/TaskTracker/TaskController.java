package com.example.TaskTracker;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


  
/* This controller handles CRUD request for Task Tracker


on initial visit, query DB to retrieve all unfinished tasks

On 


 */


@RestController
public class TaskController{

    @Autowired
    private TaskRepo taskRepo;
    // private FakeTaskDataStore fakeDataRepo;
    
    

    // @Autowired
    // public TaskController(FakeTaskDataStore repo){
    //     this.fakeDataRepo = repo;
    // }




    @GetMapping("/tasks")
    // @RequestMapping(value="/tasks",method=RequestMethod.GET)  
    public List<Task> getTasks(){
        List<Task> taskList = taskRepo.findAll();
        // // System.out.println(taskList);

        // List<Task> taskList = new ArrayList<Task>();
        // taskList.add(new Task("garbage out",false,"12/21/22","12/20/23"));
        return taskList;
    }
    @PostMapping("/tasks/add")
    // @RequestMapping(value="/addTask",method=RequestMethod.POST)
    public String addTask(Task t){
        taskRepo.save(t);
        return "redirect:/tasks";
    }

    @DeleteMapping("/tasks/{taskID}")
    // @RequestMapping(value="/tasks/{taskID}",method = RequestMethod.PUT)
    public String deleteTask(@PathVariable int taskID,HttpServletResponse response) throws IOException{
        taskRepo.deleteById(taskID);
        response.sendRedirect("/tasks");
        return "task with "+ taskID  + " deleted";
    }
    // @PutMapping("/{task.taskID}")
    // public void markCompleted(){

    // }

    // @PutMapping
    // public void editTaskDetails(){

    // }

    
}




