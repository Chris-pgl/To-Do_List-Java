package com.example.todolist.service;

import com.example.todolist.entities.Task;
import com.example.todolist.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTask(){
        return repo.findAll();
    }

    public Optional<Task> getTaskByID(Long id){
        return repo.findById(id);
    }

    public Task createTask(Task task){
        return repo.save(task);
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found "));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return repo.save(task);
    }

    public void deleteTask(Long id){
        repo.deleteById(id);
    }
}
