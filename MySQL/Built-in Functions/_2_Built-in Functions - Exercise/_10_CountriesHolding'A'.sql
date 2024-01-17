SELECT country_name, iso_code
FROM countries
WHERE LENGTH(REGEXP_REPLACE(country_name, '[^A]', '')) >= 3
ORDER BY iso_code;