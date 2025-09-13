CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE employee_status AS ENUM ('ACTIVE', 'ON_LEAVE', 'TERMINATED');
CREATE TYPE employment_types AS ENUM ('FULL', 'PART');

CREATE TABLE departments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    code INT NOT NULL UNIQUE
);

CREATE TABLE positions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    code INT NOT NULL UNIQUE
);

CREATE TABLE employees (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name TEXT NOT NULL,
    iin char(12) NOT NULL UNIQUE,
    phone char(13) NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    employed_at DATE NOT NULL,
    terminated_at DATE,
    status employee_status NOT NULL DEFAULT 'ACTIVE',
    department_id UUID REFERENCES departments(id),
    position_id UUID REFERENCES positions(id),
    grade VARCHAR(20),
    employment_type employment_types NOT NULL DEFAULT 'FULL',
    salary_base NUMERIC(12,2),
    salary_currency VARCHAR(10),
    work_schedule VARCHAR(50),
    manager UUID REFERENCES employees(id)
);

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    username TEXT UNIQUE,
    password TEXT,
    role TEXT
);