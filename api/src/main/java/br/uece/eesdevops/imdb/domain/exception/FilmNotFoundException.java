package br.uece.eesdevops.imdb.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends RuntimeException{

        /**
    *
    */
    private static final long serialVersionUID = 1L;

    public FilmNotFoundException(Integer id) {
            super("Film for id " + id + "not found");
        }
}
