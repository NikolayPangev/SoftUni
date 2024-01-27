SELECT t.town_id, t.name, a.address_text
FROM towns AS t
JOIN addresses AS a
ON t.town_id = a.town_id
WHERE t.town_id IN (9, 15, 32)
ORDER BY town_id, address_id;