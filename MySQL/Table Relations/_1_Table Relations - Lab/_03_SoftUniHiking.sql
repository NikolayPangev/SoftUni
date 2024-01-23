SELECT 
	starting_point AS route_starting_point, 
	end_point AS route_ending_point, 
	leader_id, 
	CONCAT(first_name, ' ', last_name) AS leader_name
FROM routes r
JOIN campers c ON
r.leader_id = c.id;