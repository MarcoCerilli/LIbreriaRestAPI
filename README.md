Esercizio con GET e POST Mapping con JdbcTemplate
Questo esercizio dimostra come utilizzare Spring Boot con JdbcTemplate per gestire richieste GET e POST in un'applicazione che interagisce con un database MySQL.

Tecnologie Utilizzate
Spring Boot
JdbcTemplate
MySQL
Maven
Passaggi Principali
Configurazione del progetto: Crea un progetto Spring Boot includendo le dipendenze Spring Web, Spring Data JDBC, e MySQL Driver.
Configurazione del database: Imposta MySQL con una tabella libri:
sql
Copia codice
CREATE TABLE libri (id INT AUTO_INCREMENT PRIMARY KEY, titolo VARCHAR(255), autore VARCHAR(255));
Repository con JdbcTemplate: Usa JdbcTemplate per ottenere e inserire dati nel database.
Controller: Crea un controller con i mapping GET per ottenere libri e POST per aggiungere nuovi libri:
java
Copia codice
@GetMapping
public List<Book> getAllBooks() { ... }

@PostMapping
public void addBook(@RequestBody Book book) { ... }
Test API: Usa curl per testare le richieste:
GET: curl -X GET http://localhost:8080/libri
POST: curl -X POST http://localhost:8080/libri -d '{"titolo":"Titolo","autore":"Autore"}'
Esecuzione
Avvia l'applicazione con:

bash
Copia codice
mvn spring-boot:run
L'app sarà disponibile su http://localhost:8080
