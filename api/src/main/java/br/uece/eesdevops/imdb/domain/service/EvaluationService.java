package br.uece.eesdevops.imdb.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.repository.EvaluationRepository;


@Service
public class EvaluationService {

	private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Transactional
    public Evaluation execute(Evaluation evaluation) {
        //System.out.println("O valor do id do film é " + evaluation.getFilm().getId());
        //System.out.println("O valor do titulo do film é " + evaluation.getFilm().getTitle());
        return evaluationRepository.save(evaluation);
    }
}
