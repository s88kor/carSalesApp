INSERT INTO car (id,  car_model)
VALUES  (1, 'BMW X5'),
        (2, 'BMW X6'),
        (3, 'BMW X7');

INSERT INTO customer (id, last_name, first_name, phone_number)
VALUES (1, 'Иванов', 'Сергей', '+79107891122'),
       (2, 'Коробкин', 'Олег', '+79107891155'),
       (3, 'Олейкин', 'Роман','+79107891166');

INSERT INTO orders (id,order_date, id_car, car_quantity, total_price, id_customer)
VALUES (1, '2021-10-01', 1, 1, 2000000, 1),
       (2, '2021-10-02', 2, 2, 3500000, 2),
       (3, '2021-10-02', 3, 1, 2000000, 3),
       (4, '2021-10-02', 3, 1, 2000000, 2),
       (5, '2021-10-02', 1, 2, 2000000, 2),
       (6, '2021-10-03', 2, 1, 3000000, 1);
