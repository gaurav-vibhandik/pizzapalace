           --     DROP DATABASE IF EXISTS pizzapalace;
           --     CREATE DATABASE pizzapalace ;

                DROP TABLE IF EXISTS customer cascade ;
                CREATE TABLE customer(
                customer_id CHAR(6) PRIMARY KEY,
                first_name VARCHAR(30) NOT NULL,
                last_name VARCHAR(30),
                address VARCHAR(255),
                phone_number VARCHAR(20),
                email_address VARCHAR(70),
                CONSTRAINT uk_customer_emailAddress UNIQUE(email_address)
                ) ;

                        DROP SEQUENCE IF EXISTS seq_customer_id;
                        CREATE SEQUENCE seq_customer_id
                                START 1
                                INCREMENT 1 ;

                        CREATE OR REPLACE FUNCTION set_customer_id()
                        RETURNS TRIGGER AS
                        $$
                        BEGIN
                            NEW.customer_id := 'CUS' || lpad(nextval('seq_customer_id')::TEXT, 3, '0');
                            RETURN NEW;
                        END;
                        $$ LANGUAGE plpgsql;


                        DROP TRIGGER IF EXISTS set_customer_id_trigger on customer;
						CREATE TRIGGER set_customer_id_trigger
                        BEFORE INSERT ON customer
                        FOR EACH ROW
                        EXECUTE FUNCTION set_customer_id();



            DROP TABLE IF EXISTS pizza cascade;
            CREATE TABLE pizza(
                pizza_id CHAR(5) PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                description VARCHAR(255),
                type VARCHAR(10) DEFAULT 'VEG',
                image_url VARCHAR(255),
                CONSTRAINT uk_pizza_nameAndType UNIQUE(name,type)
            );

                    DROP SEQUENCE IF EXISTS seq_pizza_id;
                    CREATE SEQUENCE seq_pizza_id
                            START 1
                            INCREMENT 1 ;

                    CREATE OR REPLACE FUNCTION set_pizza_id()
                    RETURNS TRIGGER AS
                    $$
                    BEGIN
                        NEW.pizza_id := 'ZA' || lpad(nextval('seq_pizza_id')::TEXT, 3, '0');
                        RETURN NEW;
                    END;
                    $$ LANGUAGE plpgsql;

					DROP TRIGGER IF EXISTS set_pizza_id_trigger on pizza;
                    CREATE TRIGGER set_pizza_id_trigger
                    BEFORE INSERT ON pizza
                    FOR EACH ROW
                    EXECUTE FUNCTION set_pizza_id();


        DROP TABLE IF EXISTS orders cascade;
        CREATE TABLE orders(
        order_id CHAR(6) PRIMARY KEY,
        customer_id CHAR(6) NOT NULL,
        status VARCHAR(30) DEFAULT 'CREATED',
        total_amount INTEGER NOT NULL,
        order_date_time TIMESTAMP NOT NULL,
        delivery_address VARCHAR(255) NOT NULL,
        CONSTRAINT fk_order_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id) --ON UPDATE CASCADE ON DELETE CASCADE
        );
                    DROP SEQUENCE IF EXISTS seq_order_id;
                    CREATE SEQUENCE seq_order_id
                            START 1
                            INCREMENT 1 ;

                    CREATE OR REPLACE FUNCTION set_order_id()
                    RETURNS TRIGGER AS
                    $$
                    BEGIN
                        NEW.order_id := 'ORD' || lpad(nextval('seq_order_id')::TEXT, 3, '0');
                        RETURN NEW;
                    END;
                    $$ LANGUAGE plpgsql;

					DROP TRIGGER IF EXISTS set_order_id_trigger on orders;
                    CREATE TRIGGER set_order_id_trigger
                    BEFORE INSERT ON orders
                    FOR EACH ROW
                    EXECUTE FUNCTION set_order_id();

-- creating Crust Table
                DROP TABLE IF EXISTS crust cascade ;
                CREATE TABLE crust(
                crust_id CHAR(4) PRIMARY KEY,
                crust VARCHAR(20) UNIQUE

                ) ;

                        DROP SEQUENCE IF EXISTS seq_crust_id;
                        CREATE SEQUENCE seq_crust_id
                                START 1
                                INCREMENT 1 ;

                        CREATE OR REPLACE FUNCTION set_crust_id()
                        RETURNS TRIGGER AS
                        $$
                        BEGIN
                            NEW.crust_id := 'CR' || lpad(nextval('seq_crust_id')::TEXT, 2, '0');
                            RETURN NEW;
                        END;
                        $$ LANGUAGE plpgsql;


                        DROP TRIGGER IF EXISTS set_crust_id_trigger on crust;
						CREATE TRIGGER set_crust_id_trigger
                        BEFORE INSERT ON crust
                        FOR EACH ROW
                        EXECUTE FUNCTION set_crust_id();



-- ====================================





        DROP TABLE IF EXISTS order_line;
        CREATE TABLE order_line(
        order_line_id CHAR(5) PRIMARY KEY,
        order_id CHAR(6) NOT NULL,
        pizza_id CHAR(5) NOT NULL,
        size VARCHAR(30) NOT NULL,
        quantity INTEGER NOT NULL,
        crust_id CHAR(4) NOT NULL,
        extra_cheese BOOL NOT NULL,
        total_price INTEGER NOT NULL,

        CONSTRAINT fk_orderLine_orderId FOREIGN KEY (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_orderLine_pizzaId FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id)  ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_orderLine_crustId FOREIGN KEY (crust_id) REFERENCES crust(crust_id)  ON UPDATE CASCADE ON DELETE CASCADE

        );

                    DROP SEQUENCE IF EXISTS seq_order_line_id;
                    CREATE SEQUENCE seq_order_line_id
                            START 1
                            INCREMENT 1 ;

                    CREATE OR REPLACE FUNCTION set_order_line_id()
                    RETURNS TRIGGER AS
                    $$
                    BEGIN
                        NEW.order_line_id := 'OL' || lpad(nextval('seq_order_line_id')::TEXT, 3, '0');
                        RETURN NEW;
                    END;
                    $$ LANGUAGE plpgsql;

                    DROP TRIGGER IF EXISTS set_order_line_id_trigger on order_line;
					CREATE TRIGGER set_order_line_id_trigger
                    BEFORE INSERT ON order_line
                    FOR EACH ROW
                    EXECUTE FUNCTION set_order_line_id();

-- ==================================================================================


-- Creating Topping table

                DROP TABLE IF EXISTS topping cascade ;
                CREATE TABLE topping(
                topping_id CHAR(5) PRIMARY KEY,
                name VARCHAR(20) UNIQUE ,
                type VARCHAR(10),
                price FLOAT(2) ,
                quantity INTEGER
                );

                        DROP SEQUENCE IF EXISTS seq_topping_id;
                        CREATE SEQUENCE seq_topping_id
                                START 1
                                INCREMENT 1 ;

                        CREATE OR REPLACE FUNCTION set_topping_id()
                        RETURNS TRIGGER AS
                        $$
                        BEGIN
                            NEW.topping_id := 'TP' || lpad(nextval('seq_topping_id')::TEXT, 3, '0');
                            RETURN NEW;
                        END;
                        $$ LANGUAGE plpgsql;


                        DROP TRIGGER IF EXISTS set_topping_id_trigger on topping;
						CREATE TRIGGER set_topping_id_trigger
                        BEFORE INSERT ON topping
                        FOR EACH ROW
                        EXECUTE FUNCTION set_topping_id();

-- ====================================

-- Creating Side table

                DROP TABLE IF EXISTS side cascade ;
                CREATE TABLE side(
                side_id CHAR(6) PRIMARY KEY,
                name VARCHAR(20) UNIQUE ,
                price FLOAT(2) DEFAULT 50,
                quantity INTEGER DEFAULT 100,

                ) ;

                        DROP SEQUENCE IF EXISTS seq_side_id;
                        CREATE SEQUENCE seq_side_id
                                START 1
                                INCREMENT 1 ;

                        CREATE OR REPLACE FUNCTION set_side_id()
                        RETURNS TRIGGER AS
                        $$
                        BEGIN
                            NEW.side_id := 'S' || lpad(nextval('seq_side_id')::TEXT, 3, '0');
                            RETURN NEW;
                        END;
                        $$ LANGUAGE plpgsql;


                        DROP TRIGGER IF EXISTS set_side_id_trigger on side;
						CREATE TRIGGER set_side_id_trigger
                        BEFORE INSERT ON side
                        FOR EACH ROW
                        EXECUTE FUNCTION set_side_id();




-- ====================================
-- INVENTORY TABLES
-- ====================================

-- Creating Crust Inventory Table

                DROP TABLE IF EXISTS crust_inventory cascade ;
                CREATE TABLE crust_inventory(
                crust_id VARCHAR(4) ,
                crust_size VARCHAR(7) DEFAULT 'REGULAR',
                quantity INTEGER DEFAULT 70,
                CONSTRAINT compPK_crustInventory PRIMARY KEY(crust_id,crust_size),
                CONSTRAINT fk_crustInventory_crustId FOREIGN KEY (crust_id) REFERENCES crust(crust_id)
                );


-- ====================================

-- Creating Pizza Inventory Table

                DROP TABLE IF EXISTS pizza_inventory cascade ;
                CREATE TABLE pizza_inventory(
                pizza_id CHAR(5) ,
                pizza_size VARCHAR(7) DEFAULT 'REGULAR',
                quantity INTEGER DEFAULT 70,
                CONSTRAINT compPK_pizzaInventory PRIMARY KEY(pizza_id,pizza_size),
                CONSTRAINT fk_pizzaInventory_pizzaId FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id)
                );



-- ======================================================================
-- Creating PizzaPrice Table(shows combination of Pizza+Crust+size)

                    DROP TABLE IF EXISTS pizza_price cascade ;
                    CREATE TABLE pizza_price(
                    id serial primary key,
                    pizza_id CHAR(5) ,
                    crust_id CHAR(4) ,
                    pizza_size VARCHAR(7) DEFAULT 'REGULAR',
                    price FLOAT DEFAULT 150,
                    CONSTRAINT uk_pizzaPrice_pizzaIdAndCrustIdAndSize UNIQUE(pizza_id,crust_id,pizza_size),
                    CONSTRAINT fk_pizzaPrice_pizzaId FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id) ON UPDATE CASCADE ON DELETE CASCADE,
                    CONSTRAINT fk_pizzaPrice_crustId FOREIGN KEY (crust_id) REFERENCES crust(crust_id) ON UPDATE CASCADE ON DELETE CASCADE
                    );


-- ======================================================================
-- Creating ol_topping Table(shows combination of ol+ its selected Topping)

                    DROP TABLE IF EXISTS ol_topping cascade ;
                    CREATE TABLE ol_topping(
                    order_line_id CHAR(5) ,
                    topping_id CHAR(5) ,
                    CONSTRAINT compPK_olTopping PRIMARY KEY(order_line_id,topping_id),
                    CONSTRAINT fk_olTopping_orderLineId FOREIGN KEY (order_line_id) REFERENCES order_line(order_line_id) ON UPDATE CASCADE ON DELETE CASCADE,
                    CONSTRAINT fk_olTopping_toppingId FOREIGN KEY (topping_id) REFERENCES topping(topping_id) ON UPDATE CASCADE ON DELETE CASCADE
                    );
