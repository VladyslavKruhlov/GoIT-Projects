
INSERT INTO Client (NAME)
VALUES
    ('Vlad'),
    ('Max'),
    ('Ann'),
    ('Diana'),
    ('Slavik'),
    ('Sergey'),
    ('Max'),
    ('Yuri'),
    ('Nasty'),
    ('Eli');

INSERT INTO Planet (ID, NAME)
VALUES
    ('KEPLER90B','Earth'),
    ('KEPLER90I','Mars'),
    ('KEPLER90H','Jupiter'),
    ('KEPLER90G','Saturn'),
    ('KEPLER90F','Uranus');

INSERT INTO Ticket (CREATED_AT, CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID)
VALUES
    ('2023-07-11 12:15:00', 1, 'KEPLER90G', 'KEPLER90B'),
    ('2023-07-12 12:15:00', 2, 'KEPLER90I', 'KEPLER90G'),
    ('2023-07-13 12:15:00', 3, 'KEPLER90F', 'KEPLER90H'),
    ('2023-07-14 12:15:00', 4, 'KEPLER90G', 'KEPLER90I'),
    ('2023-07-15 12:15:00', 5, 'KEPLER90H', 'KEPLER90B'),
    ('2023-07-13 12:15:00', 1, 'KEPLER90B', 'KEPLER90G'),
    ('2023-07-15 12:15:00', 4, 'KEPLER90I', 'KEPLER90F'),
    ('2023-07-11 12:15:00', 5, 'KEPLER90G', 'KEPLER90I'),
    ('2023-07-18 12:15:00', 3, 'KEPLER90I', 'KEPLER90B'),
    ('2023-07-19 12:15:00', 2, 'KEPLER90F', 'KEPLER90B');