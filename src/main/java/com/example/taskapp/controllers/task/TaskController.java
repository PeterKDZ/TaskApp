package com.example.taskapp.controllers.task;

import com.example.taskapp.dtos.task.TaskDto;
import com.example.taskapp.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class TaskController {

    private final TaskService taskService;


    @PostMapping(value = "...api/tasks")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto task = taskService.createTask(taskDto);
        //return ResponseEntity.ok(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
