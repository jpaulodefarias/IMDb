import React, { useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import services from "../../services";

const Evaluation = () => {
	const { filmId } = useParams();

	const [evaluator, setEvaluator] = useState("");
	const [score, setScore] = useState("");
	const [comment, setComment] = useState("");

	const history = useHistory();

	const submit = async e => {
		e.preventDefault();

		const evaluation = {
			filmId,
			evaluator,
			score,
			comment
		};

		try {
			await services.evaluation.add(evaluation);
			history.push("/");
		} catch (error) {
			alert("Check required fields")
		}
	};

	const cancel = () => {
		history.push("/");
	};

	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<h2>Review</h2>
			<form onSubmit={submit} className="uk-form-stacked" autoComplete="off">
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="evaluation-evaluator">Your Name</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="evaluation-evaluator" type="text" required="required"
							onChange={e => setEvaluator(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="evaluation-score">Score</label>
					<div className="uk-form-controls">
						<input className="uk-input" id="evaluation-score" type="number" required="required"
							min="0" max="5"
							onChange={e => setScore(e.target.value)}
						/>
					</div>
				</div>
				<div className="uk-margin uk-width-1-2@m">
					<label htmlFor="evaluation-comment">Comment</label>
					<div className="uk-form-controls">
						<textarea className="uk-textarea" id="evaluation-comment" type="text"
							onChange={e => setComment(e.target.value)}
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

export default Evaluation;
