package br.uece.eesdevops.imdb.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String synopsis;

	@Column(nullable = false)
	private String year;

	@Column(nullable = false)
	private String producers;

	@Column(nullable = false)
	private String actors;

	@Column(nullable = true)
	private String poster;

	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	private List<Evaluation> evaluations;

	@Transient
	private Double score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@PostLoad
	public void calculateScore() {
		this.score = evaluations.stream().mapToInt(e -> e.getScore()).average().orElse(0.0);
	}
}
