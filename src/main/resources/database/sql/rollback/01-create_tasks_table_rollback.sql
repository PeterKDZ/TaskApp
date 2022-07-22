-- liquibase formatted sql
-- changeset pkedzierski:1

drop table task_schema.tasks;
drop sequence task_schema.tasks_sequence;

-- rollback drop table tasks;