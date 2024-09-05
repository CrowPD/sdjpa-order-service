DROP TABLE IF EXISTS order_header;
CREATE TABLE IF NOT EXISTS order_header
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255)
);

INSERT INTO order_header(customer_name)
VALUES ('Michael'),
       ('Jeremy'),
       ('Star_');