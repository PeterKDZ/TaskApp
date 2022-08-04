package com.example.taskapp.controller.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.exception.TaskException;
import com.example.taskapp.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The controller for Task REST endpoints.
 * This class handles the CRUD operations for Task.
 * In addition, this class serves HTML based web pages.
 */

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    /**
     * Handle /api/tasks endpoint
     *
     * Create a new Task object, given the data provided.
     *
     * Returns one o the following HTTP status code:
     * 200: successfully created a new task
     * 409: unable to create task, because it already exists
     *
     * @param taskDto a JSON representation of taskDto object
     * @return the newly created object taskDto
     */
    @PostMapping(value = "/api/tasks")
    public ResponseEntity<Object> createTask(@RequestBody @Valid TaskDto taskDto) {
        try {
            TaskDto taskSaved = taskService.createTask(taskDto);
            return ResponseEntity.ok(taskSaved);
        } catch (TaskException taskException) {
            return new ResponseEntity<>(taskException.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
