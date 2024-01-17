SELECT 
    user_name, 
    SUBSTRING_INDEX(email, '@', -1) AS email_provider
FROM users
WHERE email LIKE '%@%'
ORDER BY email_provider, user_name;