package br.uece.eesdevops.imdb.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.domain.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {

	private final FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> getAll() {
		List<Film> films = filmService.getAll();
		return ResponseEntity.ok(films);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> save(@RequestBody Film film) {
		Film saved = filmService.save(film);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

}
