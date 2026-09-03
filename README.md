# Ambiente de ejecución en aplicaciones Java

Angel Israel Gonzalez Torres

## Parte I – Argumentos de línea de comandos

### 1. ¿Qué valor tiene `args.length` en cada ejecución?

- Con 1 argumento: 1
- Con 2 argumentos: 2
- Con 3 argumentos: 3

### 2. ¿Qué ocurre si no se proporciona ningún argumento?

`args.length` vale 0 y no se imprime ningún argumento.

### 3. ¿Todos los argumentos se reciben como texto?

Sí, llegan como String.

---

## Parte IV - Integración de los tres mecanismos

Suponga que tenemos:
En el código:
separador = ","
En application.properties:
separador=;
En una variable de ambiente:
CSV_SEPARATOR=|
Y en la línea de comandos:
java AnalizadorCSV datos.csv ":"
¿Qué valor debería utilizar el programa? Es necesario establecer una política de precedencia.

**Mayor prioridad**
Argumentos de línea de comandos
          ↓
Variables de ambiente
          ↓
Archivo properties
          ↓
Valor predeterminado
**Menor prioridad**

javac src/AnalizadorCSV.java
