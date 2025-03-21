# Esercizio con GET e POST Mapping con JdbcTemplate

Questo esercizio dimostra come utilizzare **Spring Boot** con **JdbcTemplate** per gestire richieste **GET** e **POST** in un'applicazione che interagisce con un database MySQL.

## Tecnologie Utilizzate
- **Spring Boot**
- **JdbcTemplate**
- **MySQL**
- **Maven**

## Setup del Progetto

### 1. Creazione del Progetto
Crea un progetto Spring Boot con le seguenti dipendenze:
- Spring Web
- Spring Data JDBC
- MySQL Driver

### 2. Configurazione del Database
Imposta il tuo database MySQL e crea la tabella `libri`:

```sql
CREATE TABLE libri (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  titolo VARCHAR(255), 
  autore VARCHAR(255)
);
