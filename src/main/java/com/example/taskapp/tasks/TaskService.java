package com.example.taskapp.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping(value = "/tasks")
    public TaskDto createTask(TaskDto taskDto) {
        Task task = Task.create(taskDto);
        Task save = taskRepository.save(task);
        return save.taskToDto();
    }

}
