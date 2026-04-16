-- Script para configurar PostgreSQL para el proyecto gestionclientes
-- Ejecuta este script con: psql -U postgres -f setup-postgresql.sql

-- Crear la base de datos si no existe
CREATE DATABASE gestionclientes;

-- Conectar a la base de datos
\c gestionclientes

-- Crear el usuario si no existe (opcional, puedes usar postgres directamente)
-- CREATE USER cliente WITH PASSWORD 'password123';
-- GRANT ALL PRIVILEGES ON DATABASE gestionclientes TO cliente;

-- La tabla será creada automáticamente por Hibernate al iniciar la aplicación
-- Pero si quieres crearla manualmente, descomenta lo siguiente:
/*
CREATE TABLE IF NOT EXISTS Cliente (
    identificacion VARCHAR(255) NOT NULL PRIMARY KEY,
    nombreCompleto VARCHAR(255),
    edad INTEGER,
    correo VARCHAR(255),
    telefono VARCHAR(255)
);

-- Insertar algunos datos de prueba
INSERT INTO Clientes (identificacion, nombreCompleto, edad, correo, telefono)
VALUES
  ('1010235', 'pepe', 15, 'epatero@gmail.com', 'test'),
  ('1010236', 'Elsa Patero', 16, 'elsa@gmail.com', 'Ingeniería');
*/

