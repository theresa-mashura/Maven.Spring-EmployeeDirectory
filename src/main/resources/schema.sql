

DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR2(255),
    last_name VARCHAR2(255),
    title VARCHAR2(255),
    phone_number VARCHAR2(255),
    email VARCHAR2(255),
    hire_date VARCHAR2(255),
    department_number INT,
    manager_id JAVA_OBJECT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS DEPARTMENT;

CREATE TABLE DEPARTMENT (
    id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR2(255),
    department_manager_id INT,
    PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;


