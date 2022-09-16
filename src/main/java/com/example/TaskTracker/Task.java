package com.example.TaskTracker;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
 * 
 * 
 *"This the model class where task objects are created from" 
 * Models the object we are working
 * object models relavant data
 * 
 * this class is used to model a task 
 * it has the necessary details that make up a task
 * in the main app tasks objects will be sent a retrieved
 * 
 * objects model data in a way that makes sense in the real world
 * by holding relevant pieces of what makes something up.
 * to specify something as an object, you are essentially laying out the atoms that when put together - make the object
 */


@Entity
// @NamedQuery(query = "select t from Task t",name ="query_find_all_tasks" )
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskID;
    private String taskInfo;
    private boolean completed;
    private String dateAdded;
    private String dateCompleted;
    
    
    //constructor
    public Task(){
        taskInfo = "";
        completed = false;
        dateAdded = "";
        dateCompleted = "";
    }

    //parameterized constructor
   
    public Task(String taskInfo, boolean completed,String dateAdded,String dateCompleted){
        this.taskInfo = taskInfo;
        this.completed = completed;
        this.dateAdded = dateAdded;
        this.dateCompleted = (dateCompleted != "") ? dateCompleted : "";
    }



    public int getTaskID() {
        return this.taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskInfo() {
        return this.taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public boolean isCompleted() {
        return this.completed;
    }

   

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateCompleted() {
        return this.dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Override
    public String toString() {
        return "{" +
            " taskID='" + getTaskID() + "'" +
            ", taskInfo='" + getTaskInfo() + "'" +
            ", completed='" + isCompleted() + "'" +
            ", dateAdded='" + getDateAdded() + "'" +
            ", dateCompleted='" + getDateCompleted() + "'" +
            "}";
    }


   
}



