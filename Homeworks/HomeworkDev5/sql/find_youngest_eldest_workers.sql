SELECT 'Oldest' as TYPE, NAME, BIRTHDAY
FROM worker
WHERE BIRTHDAY = (
        SELECT MIN(BIRTHDAY)
        FROM worker
    )

UNION

SELECT 'Yangest' as TYPE, NAME, BIRTHDAY
FROM worker
WHERE BIRTHDAY = (
        SELECT MAX(BIRTHDAY)
        FROM worker
    );