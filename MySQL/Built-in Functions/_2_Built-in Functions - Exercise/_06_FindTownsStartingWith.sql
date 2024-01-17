SELECT town_id, name
FROM towns
WHERE SUBSTRING(name FROM 1 FOR 1) IN ('M', 'K', 'B', 'E')
ORDER BY name;