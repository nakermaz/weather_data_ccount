create table IF NOT EXISTS weather_ccount.scanner(
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name varchar
);

create table IF NOT EXISTS weather_ccount.info(
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    value int,
    raining boolean,
    sensor_id int references weather_ccount.scanner(id)
);