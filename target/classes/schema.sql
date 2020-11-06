DROP TABLE employee;

CREATE TABLE employee
(
    employee_id SERIAL,
    first_name varchar(256),
    last_name varchar(256),
    department_id integer,
    job_title varchar(256),
    gender varchar(16),
    date_of_birth date
);