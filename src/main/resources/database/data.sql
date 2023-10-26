-- Reset the sequence values for the table's serial column to 1
SELECT setval('seq_pizza_id', 1, false);
SELECT setval('seq_customer_id', 1, false);
SELECT setval('seq_order_id', 1, false);



-- Populating Customer Table
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS001', 'John', 'Doe', '123 Main St', '555-1234', 'john.doe@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS002', 'Jane', 'Smith', '456 Elm St', '555-5678', 'jane.smith@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS003', 'Robert', 'Johnson', '789 Oak St', '555-9876', 'robert.johnson@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS004', 'Emily', 'Davis', '101 Pine St', '555-5432', 'emily.davis@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS005', 'Michael', 'Brown', '202 Maple St', '555-6789', 'michael.brown@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS006', 'Sarah', 'Wilson', '303 Cedar St', '555-7654', 'sarah.wilson@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS007', 'David', 'Anderson', '404 Birch St', '555-4321', 'david.anderson@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS008', 'Lisa', 'Miller', '505 Redwood St', '555-8765', 'lisa.miller@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS009', 'James', 'Martinez', '606 Sequoia St', '555-3456', 'james.martinez@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS010', 'Maria', 'Garcia', '707 Walnut St', '555-6543', 'maria.garcia@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS011', 'Daniel', 'Taylor', '808 Spruce St', '555-2345', 'daniel.taylor@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS012', 'Karen', 'Hernandez', '909 Cedar St', '555-8765', 'karen.hernandez@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS013', 'William', 'Lee', '1010 Oak St', '555-5678', 'william.lee@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS014', 'Linda', 'Jackson', '1111 Pine St', '555-1234', 'linda.jackson@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS015', 'Joseph', 'Lewis', '1212 Elm St', '555-9876', 'joseph.lewis@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS016', 'Nancy', 'White', '1313 Maple St', '555-6543', 'nancy.white@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS017', 'Thomas', 'Smith', '1414 Cedar St', '555-2345', 'thomas.smith@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS018', 'Patricia', 'Johnson', '1515 Birch St', '555-8765', 'patricia.johnson@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS019', 'Charles', 'Brown', '1616 Redwood St', '555-3456', 'charles.brown@email.com');
        INSERT INTO customer (customer_id, first_name, last_name, address, phone_number, email_address) VALUES ('CUS020', 'Susan', 'Davis', '1717 Sequoia St', '555-5678', 'susan.davis@email.com');




-- Populating Pizza Table ;

        INSERT INTO pizza (name, description, type, image_url) VALUES ('Margherita', 'Classic tomato and cheese pizza', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Pepperoni', 'Spicy pepperoni pizza', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Hawaiian', 'Pineapple and ham pizza', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Supreme', 'Loaded with toppings', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Mushroom', 'Mushrooms and cheese', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('BBQ Chicken', 'Barbecue chicken goodness', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Veggie Delight', 'Loaded with vegetables', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Meat Lovers', 'For meat enthusiasts', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Four Cheese', 'A cheesy delight', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Sausage and Pepper', 'Savory sausage and peppers', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Vegetarian Supreme', 'Loaded veggie goodness', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Bacon and Onion', 'Bacon and onions combo', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Pesto Chicken', 'Chicken with pesto sauce', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Spinach and Feta', 'Spinach and feta cheese', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Buffalo Chicken', 'Spicy buffalo chicken', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Pineapple Delight', 'Pineapple lovers special', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Steak and Mushroom', 'Steak and mushrooms combo', 'NON-VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Garlic and Olive', 'Garlic and olives topping', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('BBQ Veggie', 'Barbecue veggie delight', 'VEG', 'https://tinyurl.com/pizza-002');
        INSERT INTO pizza (name, description, type, image_url) VALUES ('Sausage and Mushroom', 'Sausage and mushrooms combo', 'NON-VEG', 'https://tinyurl.com/pizza-002');


-- Populating Orders Table
insert into orders values
('ORD001','CUS001','hold',600,'2023-10-03 00:00:00','address1'),
('ORD002','CUS002','hold',1200,'2023-10-07 00:00:00','address2');

-- Populating order_line table
insert into order_line values('OL001','ORD001','ZA003','Regular',2,600);
insert into order_line values('OL002','ORD002','ZA005','Large',1,300);
insert into order_line values('OL003','ORD002','ZA003','Regular',3,900);
insert into order_line values('OL004','ORD003','ZA005','Regular',3,60);
insert into order_line values('OL005','ORD003','ZA005','Large',2,100);


-- ================================================================================

--Populating Crust Table :
-- Inserting records for pizza_id ZA008
INSERT INTO crust (crust)
VALUES ('NEW_HAND_TOSSED'),('WHEAT_THIN_CRUST'),('CHEESE_BURST'),('FRESH_PAN_PIZZA');

-- =====================================================
-- Populating Toppings Table
INSERT INTO topping (topping_id, name, type, price, quantity) VALUES
  ('TP001', 'BlackOlive', 'VEG', 20, 80),
  ('TP002', 'Capsicum', 'VEG', 23, 80),
  ('TP003', 'Paneer', 'VEG', 35, 80),
  ('TP004', 'Mushroom', 'VEG', 30, 80),
  ('TP005', 'FreshTomato', 'VEG', 10, 80),
  ('TP006', 'ChickenTikka', 'NONVEG', 35, 80),
  ('TP007', 'BarbequeChicken', 'NONVEG', 45, 80),
  ('TP008', 'GrilledChicken', 'NONVEG', 40, 80);


-- ===========================================================
-- Populating Side table
INSERT INTO side (name,price, quantity) VALUES
  ('Cold Drink',60, 100),
  ('Mousse Cake',90, 200);


-- ==========================================================
-- Populating Crust Inventory
INSERT INTO crust_inventory
VALUES ('CR01','REGULAR',100),('CR01','MEDIUM',100),('CR01','LARGE',100),
('CR02','REGULAR',100),('CR02','MEDIUM',100),('CR02','LARGE',100),
('CR03','REGULAR',100),('CR03','MEDIUM',100),('CR03','LARGE',100),
('CR04','REGULAR',100),('CR04','MEDIUM',100),('CR04','LARGE',100) ;


-- ==========================================================
-- Populating Pizza Inventory
INSERT INTO pizza_inventory
VALUES ('ZA001','REGULAR',100),('ZA001','MEDIUM',100),('ZA001','LARGE',100),
('ZA002','REGULAR',100),('ZA002','MEDIUM',100),('ZA002','LARGE',100),
('ZA003','REGULAR',100),('ZA003','MEDIUM',100),('ZA003','LARGE',100),
('ZA004','REGULAR',100),('ZA004','MEDIUM',100),('ZA004','LARGE',100),
('ZA005','REGULAR',100),('ZA005','MEDIUM',100),('ZA005','LARGE',100),
('ZA006','REGULAR',100),('ZA006','MEDIUM',100),('ZA006','LARGE',100),
('ZA007','REGULAR',100),('ZA007','MEDIUM',100),('ZA007','LARGE',100),
('ZA008','REGULAR',100),('ZA008','MEDIUM',100),('ZA008','LARGE',100),
('ZA009','REGULAR',100),('ZA009','MEDIUM',100),('ZA009','LARGE',100),
('ZA010','REGULAR',100),('ZA010','MEDIUM',100),('ZA010','LARGE',100);




-- ==================================================================================
-- Populating PizzaPrice Table
INSERT INTO pizza_price (pizza_id, crust_id, pizza_size, price) VALUES
  ('ZA001', 'CR01', 'REGULAR', 100),
    ('ZA001', 'CR01', 'MEDIUM', 200),
    ('ZA001', 'CR01', 'LARGE', 300),
    ('ZA001', 'CR02', 'REGULAR', 100),
    ('ZA001', 'CR02', 'MEDIUM', 200),
    ('ZA001', 'CR02', 'LARGE', 300),
    ('ZA001', 'CR03', 'REGULAR', 100),
    ('ZA001', 'CR03', 'MEDIUM', 200),
    ('ZA001', 'CR03', 'LARGE', 300),
    ('ZA001', 'CR04', 'REGULAR', 100),
    ('ZA001', 'CR04', 'MEDIUM', 200),
    ('ZA001', 'CR04', 'LARGE', 300),
    ('ZA002', 'CR01', 'REGULAR', 100),
  ('ZA002', 'CR01', 'MEDIUM', 200),
  ('ZA002', 'CR01', 'LARGE', 300),
  ('ZA002', 'CR02', 'REGULAR', 100),
  ('ZA002', 'CR02', 'MEDIUM', 200),
  ('ZA002', 'CR02', 'LARGE', 300),
  ('ZA002', 'CR03', 'REGULAR', 100),
  ('ZA002', 'CR03', 'MEDIUM', 200),
  ('ZA002', 'CR03', 'LARGE', 300),
  ('ZA002', 'CR04', 'REGULAR', 100),
  ('ZA002', 'CR04', 'MEDIUM', 200),
  ('ZA002', 'CR04', 'LARGE', 300),
  ('ZA003', 'CR01', 'REGULAR', 100),
  ('ZA003', 'CR01', 'MEDIUM', 200),
  ('ZA003', 'CR01', 'LARGE', 300),
  ('ZA003', 'CR02', 'REGULAR', 100),
  ('ZA003', 'CR02', 'MEDIUM', 200),
  ('ZA003', 'CR02', 'LARGE', 300),
  ('ZA003', 'CR03', 'REGULAR', 100),
  ('ZA003', 'CR03', 'MEDIUM', 200),
  ('ZA003', 'CR03', 'LARGE', 300),
  ('ZA003', 'CR04', 'REGULAR', 100),
  ('ZA003', 'CR04', 'MEDIUM', 200),
  ('ZA003', 'CR04', 'LARGE', 300),
  ('ZA004', 'CR01', 'REGULAR', 100),
  ('ZA004', 'CR01', 'MEDIUM', 200),
  ('ZA004', 'CR01', 'LARGE', 300),
  ('ZA004', 'CR02', 'REGULAR', 100),
  ('ZA004', 'CR02', 'MEDIUM', 200),
  ('ZA004', 'CR02', 'LARGE', 300),
  ('ZA004', 'CR03', 'REGULAR', 100),
  ('ZA004', 'CR03', 'MEDIUM', 200),
  ('ZA004', 'CR03', 'LARGE', 300),
  ('ZA004', 'CR04', 'REGULAR', 100),
  ('ZA004', 'CR04', 'MEDIUM', 200),
  ('ZA004', 'CR04', 'LARGE', 300),
  ('ZA005', 'CR01', 'REGULAR', 100),
  ('ZA005', 'CR01', 'MEDIUM', 200),
  ('ZA005', 'CR01', 'LARGE', 300),
  ('ZA005', 'CR02', 'REGULAR', 100),
  ('ZA005', 'CR02', 'MEDIUM', 200),
  ('ZA005', 'CR02', 'LARGE', 300),
  ('ZA005', 'CR03', 'REGULAR', 100),
  ('ZA005', 'CR03', 'MEDIUM', 200),
  ('ZA005', 'CR03', 'LARGE', 300),
  ('ZA005', 'CR04', 'REGULAR', 100),
  ('ZA005', 'CR04', 'MEDIUM', 200),
  ('ZA005', 'CR04', 'LARGE', 300),
  ('ZA006', 'CR01', 'REGULAR', 100),
  ('ZA006', 'CR01', 'MEDIUM', 200),
  ('ZA006', 'CR01', 'LARGE', 300),
  ('ZA006', 'CR02', 'REGULAR', 100),
  ('ZA006', 'CR02', 'MEDIUM', 200),
  ('ZA006', 'CR02', 'LARGE', 300),
  ('ZA006', 'CR03', 'REGULAR', 100),
  ('ZA006', 'CR03', 'MEDIUM', 200),
  ('ZA006', 'CR03', 'LARGE', 300),
  ('ZA006', 'CR04', 'REGULAR', 100),
  ('ZA006', 'CR04', 'MEDIUM', 200),
  ('ZA006', 'CR04', 'LARGE', 300),
  ('ZA007', 'CR01', 'REGULAR', 100),
  ('ZA007', 'CR01', 'MEDIUM', 200),
  ('ZA007', 'CR01', 'LARGE', 300),
  ('ZA007', 'CR02', 'REGULAR', 100),
  ('ZA007', 'CR02', 'MEDIUM', 200),
  ('ZA007', 'CR02', 'LARGE', 300),
  ('ZA007', 'CR03', 'REGULAR', 100),
  ('ZA007', 'CR03', 'MEDIUM', 200),
  ('ZA007', 'CR03', 'LARGE', 300),
  ('ZA007', 'CR04', 'REGULAR', 100),
  ('ZA007', 'CR04', 'MEDIUM', 200),
  ('ZA007', 'CR04', 'LARGE', 300),
  ('ZA009', 'CR01', 'REGULAR', 100),
  ('ZA009', 'CR01', 'MEDIUM', 200),
  ('ZA009', 'CR01', 'LARGE', 300),
  ('ZA009', 'CR02', 'REGULAR', 100),
  ('ZA009', 'CR02', 'MEDIUM', 200),
  ('ZA009', 'CR02', 'LARGE', 300),
  ('ZA009', 'CR03', 'REGULAR', 100),
  ('ZA009', 'CR03', 'MEDIUM', 200),
  ('ZA009', 'CR03', 'LARGE', 300),
  ('ZA009', 'CR04', 'REGULAR', 100),
  ('ZA009', 'CR04', 'MEDIUM', 200),
  ('ZA009', 'CR04', 'LARGE', 300),
  ('ZA010', 'CR01', 'REGULAR', 100),
  ('ZA010', 'CR01', 'MEDIUM', 200),
  ('ZA010', 'CR01', 'LARGE', 300),
  ('ZA010', 'CR02', 'REGULAR', 100),
  ('ZA010', 'CR02', 'MEDIUM', 200),
  ('ZA010', 'CR02', 'LARGE', 300),
  ('ZA010', 'CR03', 'REGULAR', 100),
  ('ZA010', 'CR03', 'MEDIUM', 200),
  ('ZA010', 'CR03', 'LARGE', 300),
  ('ZA010', 'CR04', 'REGULAR', 100),
  ('ZA010', 'CR04', 'MEDIUM', 200),
  ('ZA010', 'CR04', 'LARGE', 300);


