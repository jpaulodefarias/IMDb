import React from "react";

const Item = props => {
	const { film } = props;

	return (
		<div className="uk-section uk-section-xsmall uk-section-secondary uk-light">
			<div className="uk-container">
				<h3>{film.title}</h3>
				<p>Score: {film.score}</p>
				<p>Year: {film.year}</p>
				<p>Actors: {film.actors}</p>
				<p>Producers: {film.producers}</p>
				<p>Synopsis: {film.synopsis}</p>
			</div>
		</div>
	);
};

export default Item;
