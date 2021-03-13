CREATE TABLE athlete (
	license varchar(10) NOT NULL UNIQUE,
    athlete_name varchar(50) NOT NULL,
    surnames varchar(100) NOT NULL,
    birth_date varchar(10) NOT NULL,
    created_date datetime,
	PRIMARY KEY atleta_pk(license)
);

CREATE TABLE competition (
    place varchar(50) NOT NULL,
    competition_name varchar(100) NOT NULL,
    competition_date datetime NOT NULL,
    track varchar(20) NOT NULL,
    result varchar(15) NOT NULL,
    license varchar(10) NOT NULL
)