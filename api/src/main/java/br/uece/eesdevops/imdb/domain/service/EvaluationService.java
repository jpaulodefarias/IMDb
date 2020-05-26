package br.uece.eesdevops.imdb.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.domain.exception.EvaluationEmptyException;
import br.uece.eesdevops.imdb.domain.exception.FilmNotFoundException;
import br.uece.eesdevops.imdb.domain.exception.ScoreEvaluationException;
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
			checkScore(evaluation);
			requiredEvaluator(evaluation);
			Film film = optional.get();
			filmRepository.save(film);
			return evaluationRepository.save(evaluation);
		} else {
			throw new FilmNotFoundException(id);
		}

	}

	public void checkScore(Evaluation evaluation) {
		if (evaluation.getScore() <= 0 && evaluation.getScore() >= 5) {
			throw new ScoreEvaluationException(evaluation.getScore());
		}
		if(evaluation.getScore() == null) {
			throw new EvaluationEmptyException("The score is empty or null. Please set of value");
		}
	}

	public void requiredEvaluator(Evaluation evaluation) {
		if(evaluation.getEvaluator() == null || evaluation.getEvaluator().isEmpty()) {
			throw new EvaluationEmptyException("The evaluator is null or empty. Please set of value");
		}
	}

	public List<Evaluation> getAll() {
		return this.evaluationRepository.findAll();
	}
}
