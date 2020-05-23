import React from "react";
import Film from "../Film";

const Home = props => {
	return (
		<div className="uk-light uk-background-secondary uk-padding">
			<Film.List />
		</div>
	);
};

export default Home;
