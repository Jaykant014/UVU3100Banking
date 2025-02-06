-- Create Database
CREATE DATABASE IF NOT EXISTS clz_student_banking;
USE clz_student_banking;

-- Create Students Table
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    address VARCHAR(255) NOT NULL,
    college_id VARCHAR(20) UNIQUE NOT NULL, -- Student's College ID
    password_hash VARCHAR(255) NOT NULL,
    account_status ENUM('Active', 'Suspended', 'Closed') DEFAULT 'Active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert Sample Students
INSERT INTO students (first_name, last_name, email, phone_number, address, college_id, password_hash)
VALUES 
('Alice', 'Johnson', 'alice.johnson@example.com', '+1234567890', '1234 College Ave, NY', 'C12345', SHA2('SecurePassword123', 256)),
('Bob', 'Smith', 'bob.smith@example.com', '+1987654321', '5678 Campus Dr, CA', 'C12346', SHA2('AnotherSecurePass456', 256));

-- Create Bank Accounts Table
CREATE TABLE bank_accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    account_type ENUM('Savings', 'Checking') NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE
);

-- Insert Sample Bank Accounts
INSERT INTO bank_accounts (student_id, account_number, account_type, balance) 
VALUES 
(1, 'S1234567890', 'Savings', 500.00),
(1, 'C1234567891', 'Checking', 200.00),
(2, 'S9876543210', 'Savings', 1000.00);

-- Create Transactions Table
CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type ENUM('Deposit', 'Withdrawal', 'Transfer') NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES bank_accounts(account_id) ON DELETE CASCADE
);

-- Insert Sample Transactions
INSERT INTO transactions (account_id, transaction_type, amount) 
VALUES 
(1, 'Deposit', 100.00),
(1, 'Withdrawal', 50.00),
(2, 'Deposit', 500.00);

-- Query to Verify Data
-- View Students
SELECT * FROM students;

-- View Bank Accounts
SELECT * FROM bank_accounts;

-- View Transactions
SELECT * FROM transactions;
