SELECT town_id, name
FROM towns
WHERE SUBSTRING(name FROM 1 FOR 1) NOT IN ('R', 'B', 'D')
ORDER BY name;