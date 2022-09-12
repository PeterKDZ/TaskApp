package com.example.taskapp.service.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import com.example.taskapp.exception.EntityNotFoundException;
import com.example.taskapp.exception.TaskException;
import com.example.taskapp.mapper.task.TaskMapper;
import com.example.taskapp.repository.task.TaskRepository;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTests {

    @InjectMocks
    private TaskService taskService;
    @Mock
    private TaskMapper taskMapper;
    @Mock
    TaskRepository taskRepository;

    @Test
    @DisplayName("Testing creation new TaskEntity and saving to DB - Positive")
    void createTask_shouldCreateNewTask() {
        //given
        TaskDto input = TaskDto.builder().
                name("test").
                status(Status.DONE).
                priority(Priority.HIGH).
                description("New test task").
                build();
        Task task = Task.builder().build();
        TaskDto taskDto = TaskDto.builder().build();

        when(taskMapper.convertDtoToTask(any(TaskDto.class))).thenReturn(task);
        when(taskRepository.existsTaskByNameAndStatus(anyString(), any(Status.class))).thenReturn(false);
        when(taskMapper.convertTaskToDto(any(Task.class))).thenReturn(taskDto);

        //when
        TaskDto result = taskService.createTask(input);

        //then
        verify(taskRepository, times(1)).save(task);
        assertEquals(taskDto, result);
    }

    @Test()
    @DisplayName("Testing creation new TaskEntity like existing in DB - Exception")
    void createTask_shouldThrowNewTaskException() {
        //given
        TaskDto input = TaskDto.builder().
                name("test").
                status(Status.DONE).
                build();
        Task task = Task.builder().build();

        String expectedMessage = String.format("Task with name %s and status %s is already exist", input.getName(), input.getStatus());

        when(taskMapper.convertDtoToTask(any(TaskDto.class))).thenReturn(task);
        when(taskRepository.existsTaskByNameAndStatus(anyString(), any(Status.class))).thenReturn(true);

        //when
        TaskException taskException = assertThrows(TaskException.class, () -> taskService.createTask(input));

        //then
        verify(taskRepository, times(1)).existsTaskByNameAndStatus(input.getName(), input.getStatus());
        assertThat(taskException.getMessage()).isEqualTo("Task with name test and status DONE is already exist");
        assertEquals(expectedMessage, taskException.getMessage());
    }

    @Test
    @DisplayName("Testing updating TaskEntity existing in DB - Positive")
    void updateTask_shouldUpdateTaskInDB() {
        //given
        TaskDto input = TaskDto.builder().
                id(3L).
                name("update test").
                status(Status.DONE).
                priority(Priority.NORMAL).
                description("New updating test task").
                build();

        Task task = Task.builder().build();
        TaskDto taskDto = TaskDto.builder().build();

        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskMapper.updateTaskFromDto(any(Task.class), any(TaskDto.class))).thenReturn(task);
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        when(taskMapper.convertTaskToDto(any(Task.class))).thenReturn(taskDto);

        //when
        TaskDto result = taskService.updateTask(3L, input);

        //then
        verify(taskRepository, times(1)).save(task);
        assertEquals(taskDto, result);
    }

    @Test
    @DisplayName("Testing updating TaskEntity existing in DB - Exception")
    void updateTask_shouldThrowNewEntityNotFoundException() {
        //given
        TaskDto input = TaskDto.builder().
                id(3L).
                name("update test").
                status(Status.DONE).
                priority(Priority.NORMAL).
                description("New updating test task").
                build();

        String expectedMessage = String.format("Entity with id = %s not found", input.getId());

        when(taskRepository.findById(anyLong())).thenThrow(new EntityNotFoundException(input.getId()));

        //when
        EntityNotFoundException entityNotFoundException = assertThrows(EntityNotFoundException.class, () -> taskService.updateTask(3L, input));

        //then
        assertThat(entityNotFoundException.getMessage()).isEqualTo("Entity with id = 3 not found");
        assertEquals(expectedMessage, entityNotFoundException.getMessage());
    }

}