# Configuración de PostgreSQL para el Proyecto gestionclientes

## Cambios realizados:

✅ El proyecto ha sido configurado para usar **PostgreSQL** en lugar de H2.

## Configuración en application.yml:

```yaml
datasource:
  db-kind: postgresql
  username: postgres
  password: postgres
  jdbc:
    url: "jdbc:postgresql://localhost:5432/gestionclientes"
```

## Pasos para ejecutar:

### 1. Instalar PostgreSQL (si no lo tienes)
- Descarga desde: https://www.postgresql.org/download/windows/
- Durante la instalación, anota la contraseña del usuario `postgres`

### 2. Crear la base de datos

**Opción A: Con pgAdmin (interfaz gráfica)**
- Abre pgAdmin
- Conéctate con el usuario `postgres`
- Click derecho → Create → Database
- Nombre: `gestionestudiantes`
- Click Save

**Opción B: Con línea de comandos**
```bash
# Abre una terminal y ejecuta:
psql -U postgres

# Luego ejecuta en la consola de psql:
CREATE DATABASE gestionclientes;
\q
```

**Opción C: Con el script SQL**
```bash
# Navega a la carpeta del proyecto y ejecuta:
psql -U postgres -f setup-postgresql.sql
```

### 3. Ajustar credenciales (si es necesario)

Si tu contraseña de PostgreSQL es diferente a `postgres`, edita `application.yml`:

```yaml
datasource:
  db-kind: postgresql
  username: postgres
  password: TU_CONTRASEÑA_AQUI
  jdbc:
    url: "jdbc:postgresql://localhost:5432/gestionclientes"
```

### 4. Ejecutar el proyecto

```bash
# Establecer JAVA_HOME
$env:JAVA_HOME="C:\Program Files\Java\jdk-21"

# Ejecutar en modo desarrollo
.\mvnw quarkus:dev

# O ejecutar los tests
.\mvnw test
```

## Características principales:

✅ Hibernate creará automáticamente la tabla `Estudiantes` al iniciar
✅ La contraseña predeterminada es `postgres` (ajusta según tu instalación)
✅ La estrategia es `update` (no borra datos existentes)
✅ Los logs SQL están habilitados para ver las consultas

## Verificar conexión:

Si todo está correcto, deberías ver en los logs:
```
2026-04-09 HHH000527: Bind#1 (Connection url: jdbc:postgresql://localhost:5432/gestionclientes)
```

## Solución de problemas:

### "No hay conexión a PostgreSQL"
- Verifica que PostgreSQL esté corriendo
- Comprueba el usuario y contraseña
- Confirma que la base de datos existe

### "La base de datos no se crea automáticamente"
- Ejecuta manualmente: `CREATE DATABASE gestionestudiantes;`

### Error de puerto
- PostgreSQL por defecto usa puerto 5432
- Si usas otro puerto, cambia en `application.yml`: `jdbc:postgresql://localhost:TU_PUERTO/gestionestudiantes`

