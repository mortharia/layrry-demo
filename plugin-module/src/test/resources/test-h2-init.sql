DROP TABLE IF EXISTS data;

CREATE TABLE data (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    type VARCHAR(200) NOT NULL,
    description VARCHAR(200)
);

INSERT INTO
    data (date, type, description)
VALUES
    ('2020-01-01T20:00:00Z', 'type1', 'description1'),
    ('2020-01-01T20:00:00Z', 'type2', 'description2');