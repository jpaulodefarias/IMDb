package br.uece.eesdevops.imdb.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EvaluationEmptyException extends RuntimeException{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EvaluationEmptyException(String message) {
		super(message);
	}
}
