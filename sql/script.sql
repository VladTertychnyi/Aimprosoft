DROP database IF EXISTS aimprosoftTask;
CREATE database aimprosoftTask;
use aimprosoftTask;

CREATE TABLE IF NOT EXISTS department (
  department_id   INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  department_name VARCHAR(50)
);

INSERT INTO department (department_id, department_name) VALUES
(1,'FIRST DEPARTMENT'),
(2,'SECOND DEPARTMENT'),
(3,'THIRD DEPARTMENT'),
(4,'FOURTH DEPARTMENT'),
(999,'WORKERS WITHOUT DEPARTMENT');

CREATE TABLE IF NOT EXISTS worker (
	worker_id INT (10),
	worker_login VARCHAR (50)UNIQUE,
	worker_mail VARCHAR (50) UNIQUE,
  worker_bdate DATE,
	worker_department_id INT (5),
	foreign key (worker_department_id) references department(department_id)
);

INSERT INTO worker (worker_id, worker_login, worker_mail, worker_bdate, worker_department_id) VALUES

(1, 'Ivanov', 'ivanov@gmail.com', '1956-03-21', 2),
(2, 'Petrov', 'petrov@gmail.com','1983-10-01', 1),
(3, 'Sidorov', 'sidorov@mail.ru','1973-11-30', 4),
(4, 'Lebedev', 'lebedev@mail.ru','1999-07-23', 2),
(5, 'Mikhaylov', 'mikhaylov@gmail.com','1993-04-21', 3),
(6, 'Semenov', 'semenov@mail.ru', '1991-02-14', 3),
(7, 'Smirnov', 'smirnov@mail.ru', '1988-09-03',4),
(8, 'Kuznetsov', 'kuznetsov@gmail.com','1933-01-11', 2),
(9, 'Sokolov', 'sokolov@gmail.com', '1948-07-08', 1),
(10, 'Popov', 'popov@mail.ru','1956-03-21',3);

