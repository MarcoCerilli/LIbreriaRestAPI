package Libreria.Controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Libreria.Model.Libro;



@RestController
@RequestMapping("/api/libri")
public class LibroController {
	
	
	private JdbcTemplate  jdbcTemplate; 
	
	
	public LibroController (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	
	}
	
	// Metodo aggiungi Libro
	
	@PostMapping 
	public void aggiungiLibro ( @RequestBody Libro libro) {
		
		String sql = "INSERT INTO libri (titolo, autore ) VALUES ( ?, ?)";
		jdbcTemplate.update(sql, libro.getTitolo(), libro.getAutore());		
		
	}
	
	// Metodo visualizza libri (GET)
	
	@GetMapping()
	public List <Libro> visualizzaLibri() {
		String sql = "SELECT * FROM libri";
		return jdbcTemplate.query(sql, (rs,rowNum ) -> new Libro(	
				rs.getInt("id"),
				rs.getString("titolo"),
				rs.getString("autore")
				
		));
		
	}	
		// Metodo per cercare un libro
		
		@GetMapping("/cerca")
		public List<Libro> cercaLibro(@RequestParam String titolo) {
			String sql = "SELECT * FROM libri WHERE titolo like ?";
			return jdbcTemplate.query(sql, new Object[]{"%" + titolo + "%"}, (rs, rowNum) -> new Libro(
					rs.getInt("id"),
					rs.getString("titolo"),
					rs.getString("autore")				
					
					));
	
		}
		
		// Metodo per ricwercare i libri per id 
		
		 @GetMapping("/{id}")
		 public Libro visuaLibroPerId(@PathVariable int id)  {
				String sql = "SELECT * FROM libri WHERE id =  ?";
				return jdbcTemplate.queryForObject(sql, new Object[] {id}, (rs, rowNum) -> new Libro (
						rs.getInt("id"),
						rs.getString("titolo"),
						rs.getString("autore")				
						
						));
						
						

			 
		 
		
		
		
		
		
	}
	
}

	