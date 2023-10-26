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

        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Margherita', 'Classic tomato and cheese pizza', 'VEG', 'imgurl', 10, 15, 20);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Pepperoni', 'Spicy pepperoni pizza', 'NON-VEG', 'imgurl', 12, 17, 22);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Hawaiian', 'Pineapple and ham pizza', 'VEG', 'imgurl', 11, 16, 21);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Supreme', 'Loaded with toppings', 'NON-VEG', 'imgurl', 13, 18, 23);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Mushroom', 'Mushrooms and cheese', 'VEG', 'imgurl', 10, 15, 20);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('BBQ Chicken', 'Barbecue chicken goodness', 'NON-VEG', 'imgurl', 14, 19, 24);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Veggie Delight', 'Loaded with vegetables', 'VEG', 'imgurl', 11, 16, 21);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Meat Lovers', 'For meat enthusiasts', 'NON-VEG', 'imgurl', 15, 20, 25);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Four Cheese', 'A cheesy delight', 'VEG', 'imgurl', 12, 17, 22);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Sausage and Pepper', 'Savory sausage and peppers', 'NON-VEG', 'imgurl', 13, 18, 23);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Vegetarian Supreme', 'Loaded veggie goodness', 'VEG', 'imgurl', 11, 16, 21);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Bacon and Onion', 'Bacon and onions combo', 'NON-VEG', 'imgurl', 14, 19, 24);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Pesto Chicken', 'Chicken with pesto sauce', 'NON-VEG', 'imgurl', 14, 19, 24);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Spinach and Feta', 'Spinach and feta cheese', 'VEG', 'imgurl', 12, 17, 22);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Buffalo Chicken', 'Spicy buffalo chicken', 'NON-VEG', 'imgurl', 13, 18, 23);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Pineapple Delight', 'Pineapple lovers special', 'VEG', 'imgurl', 10, 15, 20);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Steak and Mushroom', 'Steak and mushrooms combo', 'NON-VEG', 'imgurl', 15, 20, 25);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Garlic and Olive', 'Garlic and olives topping', 'VEG', 'imgurl', 11, 16, 21);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('BBQ Veggie', 'Barbecue veggie delight', 'VEG', 'imgurl', 12, 17, 22);
        INSERT INTO pizza (name, description, type, image_url, price_regular_size, price_medium_size, price_large_size) VALUES ('Sausage and Mushroom', 'Sausage and mushrooms combo', 'NON-VEG', 'imgurl', 13, 18, 23);


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
