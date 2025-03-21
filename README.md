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

3. Configurazione di JdbcTemplate
Nel tuo repository, usa JdbcTemplate per interagire con il database:

java
Copia codice
@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM libri", new BeanPropertyRowMapper<>(Book.class));
    }

    public void addBook(Book book) {
        String query = "INSERT INTO libri (titolo, autore) VALUES (?, ?)";
        jdbcTemplate.update(query, book.getTitolo(), book.getAutore());
    }
}
4. Creazione del Controller
Crea un controller con i mapping GET e POST:

java
Copia codice
@RestController
@RequestMapping("/libri")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.addBook(book);
    }
}
5. Test API
GET per ottenere tutti i libri:

bash
Copia codice
curl -X GET http://localhost:8080/libri
POST per aggiungere un nuovo libro:

bash
Copia codice
curl -X POST http://localhost:8080/libri -d '{"titolo":"Titolo","autore":"Autore"}'
Esecuzione del Progetto
Avvia l'applicazione con il comando Maven:

bash
Copia codice
mvn spring-boot:run
L'applicazione sarà disponibile su http://localhost:8080
