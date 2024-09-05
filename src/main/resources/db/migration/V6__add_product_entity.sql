DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date timestamp,
    last_modified_date timestamp,
    description VARCHAR(255),
    status      VARCHAR(25)
);

INSERT INTO product(description, status)
VALUES ('Soap', 'NEW'),
       ('Fish', 'IN_STOCK');