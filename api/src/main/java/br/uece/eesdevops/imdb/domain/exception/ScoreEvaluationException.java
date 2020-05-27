package br.uece.eesdevops.imdb.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ScoreEvaluationException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ScoreEvaluationException(Integer score) {
		super("Score" + score + "invalid. The value must be between 0 and 5");
	}
}
