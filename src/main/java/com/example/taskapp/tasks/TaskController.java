package com.example.taskapp.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto task = taskService.createTask(taskDto);
        //return ResponseEntity.ok(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
