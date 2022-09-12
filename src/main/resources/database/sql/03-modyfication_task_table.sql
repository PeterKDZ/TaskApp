-- liquibase formatted sql
-- changeset pkedzierski:1
-- add constraint on name

CREATE UNIQUE INDEX tasks_unique ON tasks (name) WHERE (status is NOT DONE)
;