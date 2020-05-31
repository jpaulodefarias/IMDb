package br.uece.eesdevops.imdb.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uece.eesdevops.imdb.domain.entity.Evaluation;
import br.uece.eesdevops.imdb.domain.service.EvaluationService;
import br.uece.eesdevops.imdb.web.Entity.NewEvaluation;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	private final EvaluationService evaluationService;

	public EvaluationController(EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Evaluation>> getAll() {
		List<Evaluation> evaluations = evaluationService.getAll();
		return ResponseEntity.ok(evaluations);

	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Evaluation> save(@RequestBody NewEvaluation request) {
		final Evaluation saved = evaluationService.save(request.toDomain());

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
}
