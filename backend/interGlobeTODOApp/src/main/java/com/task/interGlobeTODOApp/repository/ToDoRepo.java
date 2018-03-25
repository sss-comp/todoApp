package com.task.interGlobeTODOApp.repository;

import com.task.interGlobeTODOApp.model.ToDoTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends MongoRepository<ToDoTask, String> {

}