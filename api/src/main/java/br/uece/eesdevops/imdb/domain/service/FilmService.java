package br.uece.eesdevops.imdb.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.repository.FilmRepository;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
	}

	public List<Film> getAll() {
		return this.filmRepository.findAll();
	}

    @Transactional
    public Film execute(Film film) {

       return filmRepository.save(film);
    }
}
