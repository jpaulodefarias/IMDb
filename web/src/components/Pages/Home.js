import React from "react";
import Film from "../Film";

const Home = props => {
	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<h2>
				What to watch
			</h2>
			<p className="uk-heading-bullet">
				Fan favorites
			</p>
			<Film.List />
		</div>

	);
};

export default Home;
