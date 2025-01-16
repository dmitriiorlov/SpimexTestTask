-- Подготовка:
-- 1. подключиться по адресу https://sqliteonline.com/
-- 2. выбрать PostgreSQL и нажать click to connect
-- 3. Выполнить скрипты на создание таблицы и добавление данных в таблицу

-- create salary table
CREATE TABLE salary (
id INTEGER PRIMARY KEY,
name TEXT NOT NULL,
DATE DATE NOT NULL,
AMOUNT NUMERIC(20,4) NOT NULL
);

-- insert some values
INSERT INTO salary VALUES (1, 'Joanna', '2017-01-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (2, 'Joanna', '2017-02-21', 5000);
INSERT INTO salary VALUES (3, 'Joanna', '2017-03-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (4, 'Emily', '2017-03-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (5, 'Joanna', '2017-04-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (6, 'Joanna', '2017-05-21', 5000);
INSERT INTO salary VALUES (7, 'Joanna', '2017-06-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (8, 'Joanna', '2017-07-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (9, 'Joanna', '2017-08-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (10, 'Anna', '2017-08-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (11, 'Joanna', '2017-09-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (12, 'Joanna', '2017-10-21', RANDOM() * (15000-9000+1) + 9000);
INSERT INTO salary VALUES (13, 'Joanna', '2017-11-21', 5000);
INSERT INTO salary VALUES (14, 'Joanna', '2017-12-21', RANDOM() * (15000-9000+1) + 9000);

-- Задания:
-- 1. Вывести всю таблицу
-- 2. Вывести данные только по Joanna за период [март-сентябрь] 2017 года в обратном порядке (сентябрь -> август ...)
-- 3. Подсчитать сколько получила Joanna за период [март-сентябрь] 2017 года
-- 4. Вывести сколько раз Joanna получала одинаковую сумму в формате [amount | кол-во раз], например:
--                                                                                                   5000   | 3
--                                                                                                   10000  | 1 ...


