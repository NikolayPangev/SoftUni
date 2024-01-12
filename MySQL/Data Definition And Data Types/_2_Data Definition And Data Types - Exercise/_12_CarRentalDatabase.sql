CREATE TABLE categories (
    id INT PRIMARY KEY,
    category VARCHAR(50) NOT NULL,
    daily_rate DECIMAL(10 , 2 ) NOT NULL,
    weekly_rate DECIMAL(10 , 2 ) NOT NULL,
    monthly_rate DECIMAL(10 , 2 ) NOT NULL,
    weekend_rate DECIMAL(10 , 2 ) NOT NULL
);

INSERT INTO categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES
    (1, 'Economy', 40.00, 250.00, 900.00, 60.00),
    (2, 'Compact', 50.00, 300.00, 1100.00, 70.00),
    (3, 'SUV', 60.00, 350.00, 1300.00, 80.00);

CREATE TABLE cars (
    id INT PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_year INT NOT NULL,
    category_id INT,
    doors INT NOT NULL,
    picture BLOB,
    car_condition VARCHAR(100),
    available BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
VALUES
    (1, 'ABC123', 'Toyota', 'Corolla', 2022, 1, 4, 'corolla.jpg', 'Good condition', TRUE),
    (2, 'XYZ789', 'Honda', 'Civic', 2021, 2, 4, 'civic.jpg', 'Excellent condition', TRUE),
    (3, 'DEF456', 'Ford', 'Escape', 2020, 3, 5, 'escape.jpg', 'Fair condition', TRUE);

CREATE TABLE employees (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(50),
    notes TEXT
);

INSERT INTO employees (id, first_name, last_name, title, notes)
VALUES
    (1, 'John', 'Doe', 'Manager', 'Responsible for car rentals'),
    (2, 'Alice', 'Smith', 'Sales Associate', 'Handles customer inquiries'),
    (3, 'Bob', 'Johnson', 'Mechanic', 'Performs vehicle maintenance');

CREATE TABLE customers (
    id INT PRIMARY KEY,
    driver_license_number VARCHAR(20) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    zip_code VARCHAR(20),
    notes TEXT
);

INSERT INTO customers (id, driver_license_number, full_name, address, city, zip_code, notes)
VALUES
    (1, '123456789', 'Michael Johnson', '123 Main St', 'Cityville', '12345', 'Frequent customer'),
    (2, '987654321', 'Emily Davis', '456 Oak St', 'Townsville', '54321', 'VIP customer'),
    (3, '567890123', 'Daniel Wilson', '789 Pine St', 'Villagetown', '67890', 'New customer');

CREATE TABLE rental_orders (
    id INT PRIMARY KEY,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition VARCHAR(100),
    tank_level DECIMAL(5, 2),
    kilometrage_start INT,
    kilometrage_end INT,
    total_kilometrage INT,
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DECIMAL(10, 2),
    tax_rate DECIMAL(5, 2),
    order_status VARCHAR(50),
    notes TEXT,
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);

INSERT INTO rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)
VALUES
    (1, 1, 1, 1, 'Good condition', 75.5, 10000, 10500, 500, '2024-01-01', '2024-01-05', 5, 250.00, 0.1, 'Completed', 'Customer was satisfied'),
    (2, 2, 2, 2, 'Excellent condition', 90.0, 8000, 8200, 200, '2024-02-01', '2024-02-04', 3, 300.00, 0.1, 'Completed', 'Smooth rental experience'),
    (3, 3, 3, 3, 'Fair condition', 60.5, 12000, 12200, 200, '2024-03-01', '2024-03-03', 2, 200.00, 0.1, 'Completed', 'Minor issues reported by customer');