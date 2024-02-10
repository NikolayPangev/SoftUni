SELECT p.name, c.country_code, YEAR(p.established_on) AS founded_in
FROM preserves AS p
JOIN countries_preserves AS cp ON p.id = cp.preserve_id
JOIN countries AS c ON cp.country_id = c.id
WHERE MONTH(p.established_on) = 5
ORDER BY founded_in
LIMIT 5;