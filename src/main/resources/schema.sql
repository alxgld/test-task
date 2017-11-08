DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_departments;
DROP TABLE IF EXISTS company;

-- Table: company
CREATE TABLE IF NOT EXISTS company (
  company_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64)
);

-- Table: department
CREATE TABLE IF NOT EXISTS department (
  department_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  company_id INT NOT NULL ,

  FOREIGN KEY (company_id) REFERENCES company (company_id),
);


-- Table: user
CREATE TABLE IF NOT EXISTS user (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(64),
  last_name  VARCHAR(64),
  date_of_birth DATE,
  company_id INT,
  position VARCHAR(64),

  FOREIGN KEY (company_id) REFERENCES company (company_id),
);

-- Table for mapping user and department: user_departments
CREATE TABLE IF NOT EXISTS user_departments (
  user_id INT,
  department_id INT,

  FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE SET NULL ,
  FOREIGN KEY (department_id) REFERENCES department (department_id) ON DELETE SET NULL
);
