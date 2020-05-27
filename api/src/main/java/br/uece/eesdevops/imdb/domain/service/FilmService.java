package br.uece.eesdevops.imdb.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.domain.exception.FilmEmptyException;
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
		requiredTitle(film);
		requiredActors(film);
		requiredSynopsis(film);
		requiredProduces(film);
		requiredYears(film);
       return filmRepository.save(film);
	}

	private void requiredTitle(Film film) {
		if(film.getTitle() == null || film.getTitle().isEmpty()) {
			throw new FilmEmptyException("The title is empty or null. Please set a value");
		}
	}

	private void requiredActors(Film film) {
		if(film.getActors() == null || film.getActors().isEmpty()) {
			throw new FilmEmptyException("The actors is empty or null. Please set a value");
		}
	}

	private void requiredSynopsis(Film film) {
		if(film.getSynopsis() == null || film.getSynopsis().isEmpty()) {
			throw new FilmEmptyException("The synopsis is empty or null. Please set a value");
		}
	}

	private void requiredProduces(Film film) {
		if(film.getProducers() == null || film.getProducers().isEmpty()) {
			throw new FilmEmptyException("The producers is empty or null. Please set a value");
		}
	}

	private void requiredYears(Film film) {
		if(film.getYear() == null || film.getYear().isEmpty()) {
			throw new FilmEmptyException("The year is empty or null. Please set a value");
		}
	}
 }
