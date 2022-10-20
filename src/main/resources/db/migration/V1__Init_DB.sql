-- ======= 	CREATE TABLE  ========
CREATE TABLE IF NOT EXISTS table_a (
    id integer,
    current_value integer,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS table_b (
    id integer,
    current_value integer,
    PRIMARY KEY (id)
);

-- ======= 	INSERT DATA  ========
INSERT INTO table_a (id, current_value) VALUES (1, 0);
INSERT INTO table_a (id, current_value) VALUES (2, 0);
INSERT INTO table_a (id, current_value) VALUES (3, 0);

INSERT INTO table_b (id, current_value) VALUES (1, 0);
INSERT INTO table_b (id, current_value) VALUES (2, 0);
INSERT INTO table_b (id, current_value) VALUES (3, 0);