package com.example.todolist.controller;

import com.example.todolist.entities.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTask();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskByID(@PathVariable Long id){
        return service.getTaskByID(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        return service.updateTask(id,taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
