package br.uece.eesdevops.imdb.web.Entity;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.entity.Film;

public class NewEvaluation {

    private int film;

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public Evaluation toDomain() {
        Film film = new Film();
		film.setId(this.film);

        Evaluation evaluation = new Evaluation();
        evaluation.setFilm(film);

        return evaluation;
    }

}
