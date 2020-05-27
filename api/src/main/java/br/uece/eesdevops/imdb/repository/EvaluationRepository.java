package br.uece.eesdevops.imdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.uece.eesdevops.imdb.domain.entity.Evaluation;
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

	public Optional<List<Evaluation>> findByFilmId(Integer filmId);
}
