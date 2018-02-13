
CREATE TABLE orders (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    items VARCHAR(255),
    customerName VARCHAR(255),
    statuses VARCHAR(255),
    created DATETIME,
    quantity INTEGER
);

INSERT INTO orders (id, items, customerName, statuses, created, quantity) VALUES
(1, "Ginger Sesame Glazed Salmon", "Bryce", "IN_QUEUE", NOW(), 1),
(2, "Hasselback Marinara Chicken", "Bryce", "IN_QUEUE", NOW(), 1),
(3, "Nacho Steak Skillet", "Bryce", "IN_QUEUE", NOW(), 1);

SELECT * FROM orders;