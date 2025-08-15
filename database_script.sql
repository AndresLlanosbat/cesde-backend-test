CREATE TABLE docentes (
    id UUID PRIMARY KEY,
    documento BIGINT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL
);

CREATE TABLE cursos (
    id UUID PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    duracion INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    fecha_inicio TIMESTAMP NOT NULL,
    docente_id UUID NOT NULL REFERENCES docentes(id)
);

-- Datos de prueba
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('9529d209-eb65-4153-915c-a13d5b2209b4', 'juan.perez@example.com', 1001234567, 'Juan Pérez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('97987219-a188-4cb4-90c3-e2b2ef200975', 'maria.gomez@example.com', 1002345678, 'María Gómez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('b6278310-5fd9-4fba-9fa8-7c51c514c378', 'carlos.lopez@example.com', 1003456789, 'Carlos López');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('18dcb687-364e-4f73-b793-c4dff6dae795', 'ana.martinez@example.com', 1004567890, 'Ana Martínez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('d9ea5216-4e6b-406d-8f9e-2720fb6468be', 'jose.ramirez@example.com', 1005678901, 'José Ramírez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('0ce35a0e-bbdf-4eac-b8b8-d2f78fc6a698', 'laura.rodriguez@example.com', 1006789012, 'Laura Rodríguez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('db5ce59d-5dc3-4fc3-bc42-64b3a44f3679', 'pedro.sanchez@example.com', 1007890123, 'Pedro Sánchez');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('d2ff6213-31d7-40ef-96e7-759b68284466', 'sofia.torres@example.com', 1008901234, 'Sofía Torres');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('6707ab08-a795-4e29-ab45-dff4e9499fda', 'andres.castillo@example.com', 1009012345, 'Andrés Castillo');
INSERT INTO public.docentes (id, correo, documento, nombre) VALUES ('66ede12b-dbe9-475e-b897-a2af356bf2a1', 'valentina.mendoza@example.com', 1010123456, 'Valentina Mendoza');


INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('6adcb073-ca82-4e5d-81e2-344fb5941d5b', 'Curso intensivo de Java para principiantes', 40, '2025-09-01 00:00:00.000000', 'Java Básico', 350000.00, '9529d209-eb65-4153-915c-a13d5b2209b4');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('f027e565-e5b4-4e2b-81a8-24d037cb85fb', 'Introducción al desarrollo web con HTML y CSS', 20, '2025-09-05 00:00:00.000000', 'HTML & CSS', 200000.00, '97987219-a188-4cb4-90c3-e2b2ef200975');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('1cd6e831-c631-493e-9784-7d2ee349b2dc', 'Spring Boot avanzado para microservicios', 60, '2025-09-10 00:00:00.000000', 'Spring Boot Avanzado', 500000.00, 'b6278310-5fd9-4fba-9fa8-7c51c514c378');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('e838a53f-939e-48e7-9e73-2887d3dfc24a', 'Diseño de bases de datos relacionales', 30, '2025-09-15 00:00:00.000000', 'Modelado de Bases de Datos', 300000.00, '18dcb687-364e-4f73-b793-c4dff6dae795');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('529d0a67-3770-4a21-ab12-6d19fbedcfe9', 'Programación en Python para análisis de datos', 50, '2025-09-20 00:00:00.000000', 'Python Data Analysis', 400000.00, 'd9ea5216-4e6b-406d-8f9e-2720fb6468be');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('15e89849-a358-4976-9f7e-54046cb813bd', 'Introducción a JavaScript y programación frontend', 25, '2025-09-25 00:00:00.000000', 'JavaScript Básico', 250000.00, '0ce35a0e-bbdf-4eac-b8b8-d2f78fc6a698');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('bff9131a-bc1b-4d59-b37b-452f9733e151', 'Curso práctico de Docker y Kubernetes', 35, '2025-09-30 00:00:00.000000', 'Docker & Kubernetes', 450000.00, 'db5ce59d-5dc3-4fc3-bc42-64b3a44f3679');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('0ef34518-a79a-45ea-b3b1-70f315331fc6', 'Fundamentos de Ciberseguridad', 45, '2025-10-01 00:00:00.000000', 'Ciberseguridad Básica', 380000.00, 'd2ff6213-31d7-40ef-96e7-759b68284466');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('36d49349-6083-429c-a4f0-15875179dae8', 'Machine Learning con Python y scikit-learn', 55, '2025-10-05 00:00:00.000000', 'Machine Learning', 550000.00, '6707ab08-a795-4e29-ab45-dff4e9499fda');
INSERT INTO public.cursos (id, descripcion, duracion, fecha_inicio, nombre, precio, docente_id) VALUES ('1bed03b2-a745-4ab0-a02e-e208f7bda2e5', 'Desarrollo de APIs REST con Node.js', 40, '2025-10-10 00:00:00.000000', 'APIs con Node.js', 420000.00, '66ede12b-dbe9-475e-b897-a2af356bf2a1');

