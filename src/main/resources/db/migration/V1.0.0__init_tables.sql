DROP TABLE IF EXISTS atleta;
DROP TABLE IF EXISTS competicion;

CREATE TABLE atleta (
	licencia varchar(10) NOT NULL UNIQUE,
    nombre varchar(50) NOT NULL,
    apellidos varchar(100) NOT NULL,
    fecha_nacimiento varchar(10) NOT NULL,
    fecha_alta datetime,
	PRIMARY KEY atleta_pk(licencia)
);

CREATE TABLE competicion (
    lugar varchar(50) NOT NULL,
    nombre varchar(100) NOT NULL,
    fecha datetime NOT NULL,
    prueba varchar(20) NOT NULL,
    marca varchar(15) NOT NULL,
    licencia varchar(10) NOT NULL
)