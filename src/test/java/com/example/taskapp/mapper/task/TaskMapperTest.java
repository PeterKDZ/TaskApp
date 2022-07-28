package com.example.taskapp.mapper.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    @DisplayName("Testing mapping between Entity and DTO using TaskMapper - Positive")
    void convertTaskToDtoPositive() {
        // given
        Task task = new Task();
        TaskMapper taskMapper = new TaskMapper();
        // when
        TaskDto taskDto = taskMapper.convertTaskToDto(task);
        // then
        assertNotNull(taskDto);
        assertEquals(taskDto.getName(), task.getName());
    }

    @Test
    @DisplayName("Testing mapping between DTO and Entity using TaskMapper - Positive")
     void convertDtoToTaskPositive() {
        // given
        TaskDto taskDto = new TaskDto(null, "first task test", Status.DONE, Priority.LOW, "first task testing");
        TaskMapper taskMapper = new TaskMapper();
        // when
        Task task = taskMapper.convertDtoToTask(taskDto);
        // then
        assertNotNull(task);
        assertEquals(taskDto.getStatus(), task.getStatus());
    }
}