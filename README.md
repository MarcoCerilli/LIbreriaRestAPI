# LibreriaRest API

Questa è un'applicazione RESTful che gestisce una libreria. La libreria utilizza un database MySQL e JDBC Template per interagire con i dati. La funzionalità di questa API include l'aggiunta di libri, la visualizzazione di tutti i libri, la ricerca di libri per titolo e la visualizzazione di libri per ID.

## Tecnologie utilizzate

- **Spring Boot**
- **JDBC Template**
- **MySQL**
- **Spring Web**

## Setup del progetto

1. **Configurazione del database:**
   Assicurati di avere un database MySQL chiamato `libreriarest` con una tabella chiamata `libri` che ha almeno due colonne: `titolo` e `autore`.

   Configura la connessione al database nel file `DatabaseConfig.java`:

   ```java
   @Configuration
   public class DatabaseConfig {
       @Bean
       public DataSource dataSource() {
           DriverManagerDataSource dataSource = new DriverManagerDataSource();
           dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
           dataSource.setUrl("jdbc:mysql://localhost:3306/libreriarest");
           dataSource.setUsername("root");
           dataSource.setPassword("Reddino24");
           return dataSource;
       }
   }


Controller API (LibroController): Il controller fornisce i seguenti endpoint per interagire con la libreria:

Aggiungi un libro
Metodo: POST

Endpoint: /api/libri

Descrizione: Aggiungi un nuovo libro alla libreria.

Esempio di richiesta:


{
  "titolo": "Il grande Gatsby",
  "autore": "F. Scott Fitzgerald"
}


Codice del controller:

@PostMapping
public void aggiungiLibro(@RequestBody Libro libro) {
    String sql = "INSERT INTO libri (titolo, autore) VALUES (?, ?)";
    jdbcTemplate.update(sql, libro.getTitolo(), libro.getAutore());
}


Visualizza tutti i libri
Metodo: GET
Endpoint: /api/libri
Descrizione: Visualizza tutti i libri nella libreria.
Codice del controller

@GetMapping
public List<Libro> visualizzaLibri() {
    String sql = "SELECT * FROM libri";
    return jdbcTemplate.query(sql, (rs, rowNum) -> new Libro(
        rs.getInt("id"),
        rs.getString("titolo"),
        rs.getString("autore")
    ));
}

Cerca un libro per titolo
Metodo: GET
Endpoint: /api/libri/cerca
Descrizione: Cerca libri per titolo.
Parametri: titolo (stringa da cercare)

Codice del controller:

@GetMapping("/cerca")
public List<Libro> cercaLibro(@RequestParam String titolo) {
    String sql = "SELECT * FROM libri WHERE titolo LIKE ?";
    return jdbcTemplate.query(sql, new Object[]{"%" + titolo + "%"}, (rs, rowNum) -> new Libro(
        rs.getInt("id"),
        rs.getString("titolo"),
        rs.getString("autore")
    ));
}


Visualizza libro per ID
Metodo: GET
Endpoint: /api/libri/{id}
Descrizione: Visualizza un libro specifico tramite ID.
Parametri: id (ID del libro)
Codice del controller

@GetMapping("/{id}")
public Libro visuaLibroPerId(@PathVariable int id) {
    String sql = "SELECT * FROM libri WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Libro(
        rs.getInt("id"),
        rs.getString("titolo"),
        rs.getString("autore")
    ));
}


Esegui il progetto
Avvia il progetto utilizzando Spring Boot.
Testa gli endpoint utilizzando Postman o cURL per inviare richieste POST e GET.
Conclusioni
Questo progetto fornisce un'API semplice per interagire con una libreria utilizzando Spring Boot e JDBC Template. È possibile aggiungere libri, visualizzarli, cercarli per titolo e recuperare dettagli per ID.



### Come funziona:

1. **Aggiungi un libro**: Questo endpoint consente di aggiungere un libro al database inviando una richiesta `POST` con un JSON contenente il titolo e l'autore del libro.
   
2. **Visualizza tutti i libri**: Con una richiesta `GET` a `/api/libri`, ottieni tutti i libri registrati nella libreria.

3. **Cerca un libro**: Puoi cercare i libri che contengono una determinata parola nel titolo tramite il parametro `titolo`.

4. **Visualizza libro per ID**: Permette di recuperare informazioni di un libro specifico utilizzando il suo ID.

Se vuoi aggiungere altro o apportare modifiche al README, fammi sapere!


