package com.example.taskapp.service.task;

import com.example.taskapp.mapper.task.TaskMapper;
import com.example.taskapp.repository.task.TaskRepository;
import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    /**
     * Create a new TaskDto object, given the data provided.
     *
     * Converts given TaskDto object to Task object and saves it to a database.
     *
     * @param taskDto an taskDto object
     * @return the newly created object taskDto
     * @author PK
     */
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.convertDtoToTask(taskDto);
        taskRepository.save(task);
        return taskMapper.convertTaskToDto(task);
    }
}
