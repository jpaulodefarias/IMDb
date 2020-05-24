package br.uece.eesdevops.imdb.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.domain.exception.FilmNotFoundException;
import br.uece.eesdevops.imdb.repository.EvaluationRepository;
import br.uece.eesdevops.imdb.repository.FilmRepository;

@Service
public class EvaluationService {

	private final EvaluationRepository evaluationRepository;
	private FilmRepository filmRepository;

	public EvaluationService(EvaluationRepository evaluationRepository, FilmRepository filmRepository) {
		this.evaluationRepository = evaluationRepository;
		this.filmRepository = filmRepository;
	}

	@Transactional
	public Evaluation execute(Evaluation evaluation) {
		int id = evaluation.getFilm().getId();
		Optional<Film> optional = filmRepository.findById(id);

		if (optional.isPresent()) {
			Film film = optional.get();
			filmRepository.save(film);
			return evaluationRepository.save(evaluation);
		} else {
			throw new FilmNotFoundException(id);
		}

	}

	public List<Evaluation> getAll() {
		return this.evaluationRepository.findAll();
	}
}
