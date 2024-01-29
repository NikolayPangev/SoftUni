SELECT MIN(avg_salary) AS lowest_average_salary
FROM (
    SELECT AVG(salary) AS avg_salary
    FROM employees
    GROUP BY department_id
) AS department_avg_salary;