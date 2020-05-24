package br.uece.eesdevops.imdb.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.entity.Film;
import br.uece.eesdevops.imdb.domain.exception.FilmInvalidException;
import br.uece.eesdevops.imdb.domain.exception.FilmNotFoundException;
import br.uece.eesdevops.imdb.repository.EvaluationRepository;
import br.uece.eesdevops.imdb.repository.FilmRepository;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final FilmRepository filmRepository;

    public EvaluationService(final EvaluationRepository evaluationRepository, final FilmRepository filmRepository) {
        this.evaluationRepository = evaluationRepository;
        this.filmRepository = filmRepository;
    }

    @Transactional
    public Evaluation execute(Evaluation evaluation) {
        System.out.println("O valor de film é " + evaluation.getId());
        System.out.println("O valor de film é " + evaluation.getFilm().getTitle());
        requireFilm(evaluation);

        Film film = getFilmOrThrow(evaluation.getFilm().getId());

        evaluation.setFilm(film);

        return evaluationRepository.save(evaluation);
    }

    private void requireFilm(Evaluation evaluation) {
        if (evaluation.getFilm() == null || evaluation.getFilm().getId() == 0) {
            throw new FilmInvalidException("Film ID is null");
        }
    }

    private Film getFilmOrThrow(Integer filmId) {
        final Optional<Film> optional = filmRepository.findById(filmId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new FilmNotFoundException(filmId);
        }
    }
}
