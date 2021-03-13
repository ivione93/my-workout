CREATE TABLE athlete (
	license varchar(10) NOT NULL UNIQUE,
    name varchar(50) NOT NULL,
    surnames varchar(100) NOT NULL,
    birth_date varchar(10) NOT NULL,
    created_date datetime,
	PRIMARY KEY atleta_pk(license)
);

CREATE TABLE competition (
    place varchar(50) NOT NULL,
    name varchar(100) NOT NULL,
    date datetime NOT NULL,
    event varchar(20) NOT NULL,
    result varchar(15) NOT NULL,
    license varchar(10) NOT NULL
)