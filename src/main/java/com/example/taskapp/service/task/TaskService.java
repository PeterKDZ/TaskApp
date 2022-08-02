package com.example.taskapp.service.task;

import com.example.taskapp.exception.TaskAlreadyExistsException;
import com.example.taskapp.mapper.task.TaskMapper;
import com.example.taskapp.repository.task.TaskRepository;
import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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
        if (!taskDto.getName().isBlank() && taskDto.getStatus() != null) {
            //List<Task> existTaskInDB = taskRepository.findAllByNameAndStatus(taskDto.getName(), taskDto.getStatus());
            boolean existTaskInDB = taskRepository.existsTaskByNameAndStatus(taskDto.getName(), taskDto.getStatus());
            //if (existTaskInDB.isEmpty()) {
            if (!existTaskInDB) {
                taskRepository.save(task);
            } else {
                throw new TaskAlreadyExistsException("Task with name " + taskDto.getName() +
                        " and status " + taskDto.getStatus() + " is already exist");
            }
        }
        return taskMapper.convertTaskToDto(task);
    }

}
