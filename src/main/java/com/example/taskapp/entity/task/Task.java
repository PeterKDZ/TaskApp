package com.example.taskapp.entity.task;


import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import lombok.*;

import javax.persistence.*;
/**
 * The class represents entity.
 *
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks", schema = "task_schema")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column
    private String description;

}
