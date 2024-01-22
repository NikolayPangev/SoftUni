SELECT DISTINCT department_id, (
	SELECT SUM(salary)
	FROM employees
	WHERE e.department_id = employees.department_id
) AS total_salary
FROM employees e
ORDER BY department_id;