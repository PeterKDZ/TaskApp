package com.example.taskapp.service.task;

import com.example.taskapp.exception.EntityNotFoundException;
import com.example.taskapp.exception.TaskException;
import com.example.taskapp.mapper.task.TaskMapper;
import com.example.taskapp.repository.task.TaskRepository;
import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;


@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    /**
     * Create a new TaskDto object, given the data provided.
     * <p>
     * Converts given TaskDto object to Task object and saves it to a database.
     *
     * @param taskDto a taskDto object
     * @return the newly created object taskDto
     * @author PK
     */
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.convertDtoToTask(taskDto);
        boolean existTaskInDB = taskRepository.existsTaskByNameAndStatus(taskDto.getName(), taskDto.getStatus());
        if (!existTaskInDB) {
            taskRepository.save(task);
        } else {
            throw new TaskException(String.format("Task with name %s and status %s is already exist", taskDto.getName(), taskDto.getStatus()));
        }
        return taskMapper.convertTaskToDto(task);
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task taskFromDB = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Task updatedTask = taskMapper.updateTaskFromDto(taskFromDB, taskDto);
        Task saved = taskRepository.save(updatedTask);
        return taskMapper.convertTaskToDto(saved);
    }

}
