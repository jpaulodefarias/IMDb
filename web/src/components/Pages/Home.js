import React, { useState, useEffect } from "react";
import services from "../../services";
import { Link } from "react-router-dom";
import icon from "../../resources/images/film-icon.png"

const Home = props => {
	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<h2>Films</h2>
			<List />
		</div>
	);
};

const List = props => {
	const [films, setFilms] = useState([]);

	useEffect(() => {
		const fetchData = async () => {
			const _films = await services.film.list();
			setFilms(_films);
		};
		fetchData();
	}, []);

	return (
		<div>
			{films.length > 0 ? films.map(film => (
				<Item key={film.id} film={film} />
			)) :
			"There's nothing here yet"}
		</div>
	);
};

const Item = props => {
	const { film } = props;

	return (
		<React.Fragment>
			<div className="uk-grid uk-child-width-expand@s uk-light">
				<div className="uk-grid">
					<div>
						<img src={icon} width="40" alt="Film" />
					</div>
					<div>
						<h3>{film.title}</h3>
						<p>Score: {film.score}</p>
						<p>Year: {film.year}</p>
						<p>Actors: {film.actors}</p>
						<p>Producers: {film.producers}</p>
						<p>Synopsis: {film.synopsis}</p>
					</div>
				</div>
				<div>
					<div className="uk-panel">
						<h3 className="uk-align-left">Reviews</h3>
						<Link to={`/evaluation/${film.id}`} className="uk-align-right">
							<span className="uk-button uk-button-text">Add New Review</span>
						</Link>
					</div>
					{film.evaluations.length > 0 ? film.evaluations.map(e => (
						<Comment key={e.id} evaluation={e} />
					)) :
					"There's nothing here yet"}
				</div>
			</div>
			<hr />
		</React.Fragment>
	);
};

const Comment = props => {
	const { evaluation } = props;

	return (
		<div>
			<ul className="uk-comment-meta uk-subnav uk-subnav-divider uk-margin-remove-bottom">
				<li><span role="img" aria-label="Score">&#11088; {evaluation.score}</span></li>
				<li>{evaluation.evaluator}</li>
			</ul>
			<p className="uk-comment-meta uk-margin-remove-top">"{evaluation.comment}"</p>
		</div>
	);
};

export default Home;
