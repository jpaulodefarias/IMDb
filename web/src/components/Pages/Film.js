import React from "react";

const Form = props => {
	const submit = e => {
		e.preventDefault();
		console.log("submit");
	};

	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<h2>Film</h2>
			<form onSubmit={submit} className="uk-form-stacked" autoComplete="off">
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-title">Title</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-title" type="text" />
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-synopsis">Synopsis</label>
					<div className="uk-form-controls">
						<textarea className="uk-textarea" id="film-synopsis" type="text" />
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-year">Year</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-year" type="text" />
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-producers">Producers</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-producers" type="text" />
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="film-actors">Actors</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="film-actors" type="text" />
					</div>
				</div>
				<input type="submit" className="uk-button uk-button-default" value="Save" />
			</form>
		</div>
	);
};

export default {
	Form
};
