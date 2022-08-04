package com.example.taskapp.service.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTests {

    @InjectMocks
    private TaskService taskService;
    @Mock
    private TaskMapper taskMapper;
    @Mock
    TaskRepository taskRepository;

    @Before
    public void init() {
        TaskDto taskDto = TaskDto.builder().
                id(2L).
                name("test").
                status(Status.DONE).
                priority(Priority.HIGH).
                description("New test task").
                build();
        given(taskRepository.existsTaskByNameAndStatus(taskDto.getName(), taskDto.getStatus())).willReturn(true);
    }

    @Test
    @DisplayName("Testing creation new TaskEntity and saving to DB - Positive")
    void createTask_shouldCreateNewTask() {
        //given
        TaskDto taskDto = TaskDto.builder().
                id(2L).
                name("test").
                status(Status.DONE).
                priority(Priority.HIGH).
                description("New test task").
                build();
        //given(taskService.createTask(taskDto)).willReturn(preparedTaskDtoTest1);
        //when
        when(taskService.createTask(taskDto)).thenReturn(preparedTaskDtoTest1);
        TaskDto taskDtoSaved = taskService.createTask(taskDto);

        //then
        assertEquals(preparedTaskDtoTest1, taskDtoSaved);
    }

    @Test
    @DisplayName("Testing creation new TaskEntity existing in DB - Exception")
    void createTask_shouldThrowNewTaskException() {
        //given
        TaskDto taskDtoTest2 = TaskDto.builder().
                id(2L).
                name("test").
                status(Status.DONE).
                priority(Priority.HIGH).
                description("New test task").
                build();

        //when
        when(taskService.createTask(taskDtoTest2)).thenThrow(new TaskException("Task with name " + taskDtoTest2.getName() +
                " and status " + taskDtoTest2.getStatus() + " is already exist"));
        TaskDto taskDtoSaved = taskService.createTask(taskDtoTest2);

        //then
        //assertThrows(TaskException, new TaskException("task"));

    }

    TaskDto preparedTaskDtoTest1 = TaskDto.builder().
            id(2L).
            name("First").
            status(Status.DONE).
            priority(Priority.HIGH).
            description("New test task").
            build();

}