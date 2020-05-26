package br.uece.eesdevops.imdb.web.Entity;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.entity.Film;

public class NewEvaluation {

	private int filmId;
	private int score;
	private String comment;
	private String evaluator;

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public String getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Evaluation toDomain() {
		Film film = new Film();
		film.setId(this.filmId);

		Evaluation evaluation = new Evaluation();
		evaluation.setFilm(film);
		evaluation.setScore(score);
		evaluation.setComment(comment);
		evaluation.setEvaluator(evaluator);

		return evaluation;
	}

}
