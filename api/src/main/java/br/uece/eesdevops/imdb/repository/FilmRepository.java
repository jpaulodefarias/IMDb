package br.uece.eesdevops.imdb.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uece.eesdevops.imdb.domain.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
	//Optional<Film> findById(Film film);
    
}