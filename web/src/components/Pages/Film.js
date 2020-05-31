import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import services from "../../services";

const Form = props => {
	const [title, setTitle] = useState("");
	const [synopsis, setSynopsis] = useState("");
	const [year, setYear] = useState("");
	const [producers, setProducers] = useState("");
	const [actors, setActors] = useState("");
	// const [poster, setPoster] = useState("");

	const history = useHistory();

	const submit = async e => {
		e.preventDefault();

		const film = {
			title,
			synopsis,
			year,
			producers,
			actors,
			// poster
		};

		try {
			await services.film.add(film);
			history.push("/");
		} catch (error) {
			alert("Check required fields");
		}
	};

	const cancel = () => {
		history.push("/");
	};

	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<h2>Film</h2>
			<form onSubmit={submit} className="uk-form-stacked" autoComplete="off">
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-title">Title</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-title" type="text" required="required"
							onChange={e => setTitle(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-synopsis">Synopsis</label>
					<div className="uk-form-controls">
						<textarea className="uk-textarea" id="film-synopsis" type="text" required="required"
							onChange={e => setSynopsis(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-year">Year</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-year" type="text" required="required"
							onChange={e => setYear(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-producers">Producers</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-producers" type="text" required="required"
							onChange={e => setProducers(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-actors">Actors</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-actors" type="text" required="required"
							onChange={e => setActors(e.target.value)}
						/>
					</div>
				</div>
				<input type="submit" className="uk-button uk-button-default" value="Save" />
				<input type="button"
					className="uk-button uk-button-default uk-margin-small-left"
					value="Cancel"
					onClick={cancel}
				/>
			</form>
		</div>
	);
};

export default {
	Form
};
