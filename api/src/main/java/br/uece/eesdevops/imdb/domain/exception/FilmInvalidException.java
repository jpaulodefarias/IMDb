package br.uece.eesdevops.imdb.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class FilmInvalidException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FilmInvalidException(String message) {
        super(message);
    }
    
}