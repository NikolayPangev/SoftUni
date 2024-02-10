SELECT p.name, COUNT(is_armed) AS armed_workers
FROM preserves AS p
JOIN workers AS w ON p.id = w.preserve_id
WHERE is_armed = 1
GROUP BY p.name
ORDER BY armed_workers DESC, p.name ASC;