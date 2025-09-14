ALTER TABLE users
    ADD COLUMN employee_id UUID;

ALTER TABLE users
    ADD CONSTRAINT fk_user_employee
        FOREIGN KEY (employee_id) REFERENCES employees(id);