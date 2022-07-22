package com.example.taskapp.controller.task;

import com.example.taskapp.dto.TaskDto;
import com.example.taskapp.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/api/tasks")
    public TaskDto createTask(@RequestBody @Valid TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    //@PostMapping(value = "/api/tasks")
    //public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
    //    TaskDto task = taskService.createTask(taskDto);
    //    //return ResponseEntity.ok(task);
    //    return ResponseEntity.status(HttpStatus.CREATED).body(task);
    //}
}
