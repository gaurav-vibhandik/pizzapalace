           --     DROP DATABASE IF EXISTS pizzapalace;
           --     CREATE DATABASE pizzapalace ;

                DROP TABLE IF EXISTS customer cascade ;
                CREATE TABLE customer(
                customer_id CHAR(6) PRIMARY KEY,
                first_name VARCHAR(30) NOT NULL,
                last_name VARCHAR(30),
                address VARCHAR(255),
                phone_number VARCHAR(20),
                email_address VARCHAR(70)
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
                price_regular_size INTEGER NOT NULL,
                price_medium_size INTEGER NOT NULL,
                price_large_size INTEGER NOT NULL
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






        DROP TABLE IF EXISTS order_line;
        CREATE TABLE order_line(
        order_line_id CHAR(5) PRIMARY KEY,
        order_id CHAR(6) NOT NULL,
        pizza_id CHAR(6) NOT NULL,
        size VARCHAR(30) NOT NULL,
        quantity INTEGER NOT NULL,
        total_price INTEGER NOT NULL,
        CONSTRAINT fk_orderLine_orderId FOREIGN KEY (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT fk_orderLine_pizzaId FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id)  --ON UPDATE CASCADE ON DELETE CASCADE
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

