-- liquibase formatted sql
-- changeset pkedzierski:1
-- rollback - drop task schema and task sequence;

drop table task_schema.tasks;
drop sequence task_schema.tasks_sequence;

