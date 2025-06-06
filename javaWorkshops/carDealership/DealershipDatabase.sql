DROP DATABASE IF EXISTS carDealership;
CREATE DATABASE carDealership;

CREATE TABLE dealership (
dealership_id int NOT NULL AUTO_INCREMENT,
`name` varchar(50) NOT NULL,
address varchar(50) NOT NULL,
phone varchar(12),
PRIMARY KEY (dealership_id)
);

INSERT INTO dealership(`name`, address, phone)
VALUES("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");

INSERT INTO dealership(`name`, address, phone)
VALUES("A & Z Used Cars", "123 Cars Rd", "800-555-1236");


CREATE TABLE vehicles(
VIN varchar(50) NOT NULL,
make_model varchar(50) NOT NULL,
sold BOOLEAN,
PRIMARY KEY (VIN)
);

INSERT INTO vehicles(VIN, make_model, sold)
VALUES("1FTFW1ET5EKE12345", "FORD F-150", false);

INSERT INTO vehicles(VIN, make_model, sold)
VALUES("1FTFW1ET5EKE12342", "FORD MUSTANG", false);

INSERT INTO vehicles(VIN, make_model, sold)
VALUES("1FTFW1ET5EKE12347", "TOYOTA 4-RUNNER", false);

ALTER TABLE vehicles
ADD COLUMN year INT;

ALTER TABLE vehicles
ADD COLUMN vehicle_type VARCHAR(30);

ALTER TABLE vehicles
ADD COLUMN color VARCHAR(30);

ALTER TABLE vehicles
ADD COLUMN odometer INT;

ALTER TABLE vehicles
ADD COLUMN price DECIMAL(10,2);

UPDATE vehicles SET
  vehicle_type = 'COUPE',
  color = 'RED',
  odometer = 25000,
  price = 27000.00,
  year = 2018
WHERE vin = '1FTFW1ET5EKE12342';

UPDATE vehicles SET
  vehicle_type = 'PICKUP',
  color = 'BLUE',
  odometer = 40000,
  price = 35000.00,
  year = 2019
WHERE vin = '1FTFW1ET5EKE12345';

UPDATE vehicles SET
  vehicle_type = 'SUV',
  color = 'WHITE',
  odometer = 30000,
  price = 32000.00,
  year = 2020
WHERE vin = '1FTFW1ET5EKE12347';

ALTER TABLE vehicles
MODIFY COLUMN sold BOOLEAN AFTER price;


CREATE TABLE inventory(
dealership_id int NOT NULL,
VIN varchar(50),
PRIMARY KEY (dealership_id, VIN),
FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id),
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO inventory(dealership_id, VIN)
VALUES(1, "1FTFW1ET5EKE12345");

INSERT INTO inventory(dealership_id, VIN)
VALUES(2, "1FTFW1ET5EKE12347");

INSERT INTO inventory(dealership_id, VIN)
VALUES(1, "1FTFW1ET5EKE12342");

CREATE TABLE sales_contracts (
    sales_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(50) NOT NULL,
    VIN VARCHAR(50) NOT NULL,
    sales_tax DECIMAL(5,3) DEFAULT 0.05,
    recording_fee DECIMAL(10,2) DEFAULT 100.00,
    processing_fee DECIMAL(10,2),
    is_financed BOOLEAN,
    PRIMARY KEY (sales_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO sales_contracts(customer_name, VIN, processing_fee, is_financed)
VALUES("Rosario Miller-Canales", "1FTFW1ET5EKE12345", 495.00, false);

CREATE TABLE lease_contracts(
    lease_id int NOT NULL AUTO_INCREMENT,
    customer_name varchar(50) NOT NULL,
    VIN varchar(50) NOT NULL,
    lease_fee DECIMAL(10,2) DEFAULT 0.07,
    value_rate DECIMAL(10,2) DEFAULT 0.50,
    PRIMARY KEY (lease_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO lease_contracts(customer_name, VIN)
VALUES("MYLES MILLER", "1FTFW1ET5EKE12342");