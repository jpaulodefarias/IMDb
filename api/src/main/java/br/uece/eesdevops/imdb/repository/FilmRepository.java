package br.uece.eesdevops.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.uece.eesdevops.imdb.domain.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
