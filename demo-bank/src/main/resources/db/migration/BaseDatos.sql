-- Creación de la tabla 'persona'
CREATE TABLE persona (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    edad INT,
    identificacion VARCHAR(255) NOT NULL UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(255)
);

-- Creación de la tabla 'cliente'
CREATE TABLE cliente (
    id INT PRIMARY KEY REFERENCES persona(id),
    clienteid VARCHAR(255) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    estado VARCHAR(100)
);

-- Creación de la tabla 'cuenta'
CREATE TABLE cuenta (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(100),
    saldo_inicial DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(100)
);

-- Creación de la tabla 'movimiento'
CREATE TABLE movimiento (
    id SERIAL PRIMARY KEY,
    cuenta_id INT REFERENCES cuenta(id),
    fecha TIMESTAMP NOT NULL,
    tipo_movimiento VARCHAR(100),
    valor DECIMAL(10, 2) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL
);
