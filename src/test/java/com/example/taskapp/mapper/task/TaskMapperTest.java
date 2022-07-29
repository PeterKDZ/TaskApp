package com.example.taskapp.mapper.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    @DisplayName("Testing mapping between Entity and DTO using TaskMapper - Positive")
    void convertTaskToDto_shouldMapEntityToDto() {
        // given
        Task task = Task.builder().
                id(1L).name("new task").
                status(Status.TO_DO).
                priority(Priority.ULTRA).
                description("very important task").
                build();

        // when
        TaskDto taskDto = taskMapper.convertTaskToDto(task);

        // then
        assertNotNull(taskDto);
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getName(), task.getName());
        assertEquals(taskDto.getStatus(), task.getStatus());
        assertEquals(taskDto.getPriority(), task.getPriority());
        assertEquals(taskDto.getDescription(), task.getDescription());
    }

    @Test
    @DisplayName("Testing mapping between DTO and Entity using TaskMapper - Positive")
    void convertDtoToTask_shouldMapDtoToEntity() {
        // given
        TaskDto taskDto = TaskDto.builder().
                id(null).
                name("first task test").
                status(Status.DONE).
                priority(Priority.LOW).
                description("first task to testing").
                build();

        // when
        Task task = taskMapper.convertDtoToTask(taskDto);

        // then
        assertNotNull(task);
        assertEquals(taskDto.getName(), task.getName());
        assertEquals(taskDto.getStatus(), task.getStatus());
        assertEquals(taskDto.getPriority(), task.getPriority());
        assertEquals(taskDto.getDescription(), task.getDescription());
    }
}