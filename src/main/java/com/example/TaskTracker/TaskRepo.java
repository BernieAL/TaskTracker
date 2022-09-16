package com.example.TaskTracker;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/* This class has the methods that interact with the DB
 * 
 * Controller uses these methods to communicate with DB
 * 
 treat TasksData as dummy DB for now


 For each json element - create a java object

 */


@Repository
public interface TaskRepo extends JpaRepository<Task,Integer>{


        List<Task> findAll();
        

   
    

   

}

 


   