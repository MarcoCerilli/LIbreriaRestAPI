# LibreriaRest API

API per la gestione di una libreria con Spring Boot e JDBC Template.

## Tecnologie
- **Spring Boot**
- **JDBC Template**
- **MySQL**

## Setup

1. **Configurazione del database**  
   Configura il database MySQL `libreriarest` e la tabella `libri` con le colonne `titolo` e `autore`.

   **DatabaseConfig.java**
   ```java
   @Bean
   public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/libreriarest");
       dataSource.setUsername("root");
       dataSource.setPassword("Reddino24");
       return dataSource;
   }

2. API Endpoints

Aggiungi libro

-Metodo: POST
-URL: /api/libri
-Request Body:

{
  "titolo": "Il grande Gatsby",
  "autore": "F. Scott Fitzgerald"
}


Visualizza libri          -Metodo: GET                -URL: /api/libri              -Response: Lista di tutti i libri

Cerca libro per titolo                  -Metodo: GET             -URL: /api/libri/cerca               -Parametri: titolo

Visualizza libro per ID               -Metodo: GET                -URL: /api/libri/{id}           -Response: Dettagli del libro con id specificato



Esegui il progetto

1. Avvia il progetto con Spring Boot.
2. Usa Postman o cURL per testare gli endpoint.


Conclusioni
API RESTful per la gestione di una libreria. Supporta operazioni di aggiunta, visualizzazione e ricerca di libri.


