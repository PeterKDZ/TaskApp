package com.example.taskapp.service.task;

import com.example.taskapp.mapper.task.TaskMapper;
import com.example.taskapp.repository.task.TaskRepository;
import com.example.taskapp.dto.TaskDto;
import com.example.taskapp.entity.task.Task;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.convertDtoToTask(taskDto);
        taskRepository.save(task);
        return taskMapper.convertTaskToDto(task);
    }

}
