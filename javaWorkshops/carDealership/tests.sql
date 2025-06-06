-- 1.Get all dealerships
SELECT * FROM cardealership.dealership;

-- 2. Find all vehicles for a specific dealership
SELECT v.VIN, make_model, year, vehicle_type, color, odometer, price, name AS InventoryAtThisDealership
FROM cardealership.vehicles AS v
JOIN inventory AS i ON v.VIN = i.VIN
JOIN dealership AS d ON i.dealership_id = d.dealership_id
WHERE i.dealership_id = 1;

-- 3. Find a car by VIN
SELECT * FROM cardealership.vehicles
WHERE VIN = "1FTFW1ET5EKE12347";

-- 4. Find the dealership where a certain car is located, by VIN
SELECT v.VIN, make_model, year, vehicle_type, name AS DealershipWhereCarLocated
FROM cardealership.vehicles AS v
JOIN inventory AS i ON v.VIN = i.VIN
JOIN dealership AS d ON i.dealership_id = d.dealership_id;

-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT make_model, name AS DealershipWhereCarLocated
FROM cardealership.dealership AS d
JOIN inventory AS i ON d.dealership_id = i.dealership_id
JOIN vehicles AS v ON i.VIN = v.VIN
WHERE make_model LIKE "FORD MUSTANG";

-- 6. Get all sales information for a specific dealer for a specific date range
SELECT sales_id, v.VIN, customer_name, sales_tax, recording_fee, processing_fee, is_financed, make_model, year, vehicle_type, color, odometer, price, sold
FROM cardealership.sales_contracts AS c
JOIN vehicles AS v ON c.VIN = v.VIN
WHERE price = "35000.00";