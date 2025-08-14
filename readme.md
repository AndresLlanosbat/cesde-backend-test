# Sistema de Gestión de Cursos y Docentes - Spring Boot + PostgreSQL

Este proyecto es una API REST desarrollada en **Java** con **Spring Boot**, utilizando **PostgreSQL** como base de datos.  
Permite gestionar cursos y docentes, así como realizar búsquedas filtradas.

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

---

## Estructura del proyecto
src/
├─ main/java/com/cesde/cesde_backend_test/
│ ├─ controller/ → Controladores REST
│ ├─ service/ → Interfaces de servicios
│ ├─ serviceImpl/ → Implementaciones de servicios
│ ├─ entity/ → Entidades JPA
│ ├─ dto/ → Objetos de transporte de datos
│ ├─ repository/ → Repositorios JPA
│ └─ CesdeBackendTestApplication.java → Clase principal
└─ main/resources/
├─ application.properties

---

## Configuración de la base de datos (PostgreSQL)

Antes de iniciar el proyecto, crea la base de datos en PostgreSQL:

```sql
CREATE DATABASE cesde_backend;

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
```

## Instalacion

Clonar el repositorio
```bash
git clone https://github.com/AndresLlanosbat/cesde-backend-test.git
````
Navegar a la carpeta
```bash
cd cesde-backend-test
```
Instalacion de dependencias y ejecucion del programa
````bash
mvn clean install
mvn spring-boot:run
````

# API Endpoints - Docentes y Cursos

```json
{
  "status": 200,
  "message": "Mensaje de respuesta",
  "data": [...]
}
````

---

## Endpoints de Docentes (`/api/docentes`)

### 1. Obtener todos los docentes

**GET** `/api/docentes`

**Descripción:** Retorna la lista completa de docentes registrados.

**Respuesta exitosa (200):**

```json
{
  "status": 200,
  "message": "Docentes obtenidos con exito",
  "data": [
    {
      "id": "uuid",
      "nombre": "Juan Pérez",
      "documento": 123456789,
      "correo": "juan@example.com"
    }
  ]
}
```

---

### 2. Filtrar por nombre

**GET** `/api/docentes/filtrar/nombre`

**Parámetros:**

| Nombre | Tipo   | Requerido | Descripción         |
| ------ | ------ | --------- | ------------------- |
| nombre | String | ✅         | Nombre del docente. |

**Ejemplo de petición:**

```
GET /api/docentes/filtrar/nombre?nombre=Juan
```

---

### 3. Filtrar por documento

**GET** `/api/docentes/filtrar/documento`

**Parámetros:**

| Nombre    | Tipo | Requerido | Descripción                |
| --------- | ---- | --------- | -------------------------- |
| documento | Long | ✅         | Número de documento único. |

**Ejemplo de petición:**

```
GET /api/docentes/filtrar/documento?documento=123456789
```

---

### 4. Filtrar por correo

**GET** `/api/docentes/filtrar/correo`

**Parámetros:**

| Nombre | Tipo   | Requerido | Descripción               |
| ------ | ------ | --------- | ------------------------- |
| correo | String | ✅         | Correo electrónico único. |

**Ejemplo de petición:**

```
GET /api/docentes/filtrar/correo?correo=juan@example.com
```

---

### 5. Búsqueda combinada

**GET** `/api/docentes/buscar-docente`

**Parámetros opcionales:**

| Nombre    | Tipo   | Requerido | Descripción                     |
| --------- | ------ | --------- | ------------------------------- |
| nombre    | String | ❌         | Filtrar por nombre.             |
| documento | Long   | ❌         | Filtrar por documento.          |
| correo    | String | ❌         | Filtrar por correo electrónico. |

**Ejemplo de petición:**

```
GET /api/docentes/buscar-docente?nombre=Juan&documento=123456789
```

**Nota:** Retorna un `List<Docente>` sin envolver en `ApiResponse`.

---

## Endpoints de Cursos (`/api/cursos`)

### 1. Obtener todos los cursos

**GET** `/api/cursos`

**Descripción:** Retorna la lista completa de cursos registrados.

---

### 2. Filtrar por nombre

**GET** `/api/cursos/filtrar/nombre`

**Parámetros:**

| Nombre | Tipo   | Requerido | Descripción       |
| ------ | ------ | --------- | ----------------- |
| nombre | String | ✅         | Nombre del curso. |

**Ejemplo:**

```
GET /api/cursos/filtrar/nombre?nombre=Matemáticas
```

---

### 3. Filtrar por rango de precios

**GET** `/api/cursos/filtrar/precio`

**Parámetros:**

| Nombre    | Tipo       | Requerido | Descripción              |
| --------- | ---------- | --------- | ------------------------ |
| precioMin | BigDecimal | ✅         | Precio mínimo del curso. |
| precioMax | BigDecimal | ✅         | Precio máximo del curso. |

**Ejemplo:**

```
GET /api/cursos/filtrar/precio?precioMin=100.00&precioMax=300.00
```

---

### 4. Filtrar por docente

**GET** `/api/cursos/filtrar/docente`

**Parámetros:**

| Nombre    | Tipo | Requerido | Descripción                      |
| --------- | ---- | --------- | -------------------------------- |
| docenteId | UUID | ✅         | Identificador único del docente. |

**Ejemplo:**

```
GET /api/cursos/filtrar/docente?docenteId=550e8400-e29b-41d4-a716-446655440000
```

---

### 5. Búsqueda combinada

**GET** `/api/cursos/buscar-curso`

**Parámetros opcionales:**

| Nombre    | Tipo       | Requerido | Descripción                   |
| --------- | ---------- | --------- | ----------------------------- |
| nombre    | String     | ❌         | Filtrar por nombre del curso. |
| precioMin | BigDecimal | ❌         | Filtrar por precio mínimo.    |
| precioMax | BigDecimal | ❌         | Filtrar por precio máximo.    |
| docenteId | UUID       | ❌         | Filtrar por docente asignado. |

**Ejemplo:**

```
GET /api/cursos/buscar-curso?nombre=Java&precioMin=100&precioMax=500
```

