INSERT INTO worker (NAME , BIRTHDAY, LEVEL, SALARY)
VALUES
    ('Vlad', '1994-02-01', 'Middle', 4500),
    ('Max', '1995-05-25', 'Senior', 5500),
    ('Ann', '1997-11-28', 'Junior', 850),
    ('Diana', '1996-06-20', 'Middle', 2500),
    ('Slavik', '1998-08-10', 'Middle', 3000),
    ('Sergey', '1995-05-25', 'Junior', 1850),
    ('Max', '1995-11-22', 'Junior', 850),
    ('Yuri', '1996-02-08', 'Middle', 2500),
    ('Nasty', '2000-01-10', 'Middle', 2000),
    ('Eli', '1997-09-27', 'Junior', 1000);

INSERT INTO client (NAME)
VALUES
    ('Google'),
    ('Facebook'),
    ('Tesla'),
    ('Samsung'),
    ('Microsoft');

--INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
--VALUES
--    (5, '2023-01-25', '2023-02-25'),
--    (3, '2019-05-25', '2024-08-25'),
--    (3, '2018-05-01', '2025-05-01'),
--    (1, '2020-06-30', '2023-02-28'),
--    (2, '2017-02-01', '2022-02-01'),
--    (2, '2015-05-25', '2018-02-25'),
--    (4, '2014-04-01', '2017-09-01'),
--    (2, '2023-08-30', '2025-10-30'),
--    (1, '2006-02-15', '2010-02-15'),
--    (5, '2010-05-18', '2012-02-18');
--
--insert into project_worker (PROJECT_ID, WORKER_ID)
--VALUES
--    (1, 1),
--    (1, 2),
--    (1, 4),
--    (1, 10),
--    (2, 3),
--    (2, 5),
--    (3, 6),
--    (4, 7),
--    (4, 8),
--    (4, 9),
--    (5, 1),
--    (5, 10),
--    (6, 5),
--    (7, 8),
--    (8, 4),
--    (9, 3),
--    (10, 2);