CREATE TABLE orders (
    ID int,
    OrderDate datetime,
    CustomerEmail varchar(255)
);

INSERT INTO orders (id, orderdate, customeremail) VALUES (1, '2024-09-20', 'customer@email.com');
INSERT INTO orders (id, orderdate, customeremail) VALUES (2, '2024-04-23', 'customer2@email2.com');