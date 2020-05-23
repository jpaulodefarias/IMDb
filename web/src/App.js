import React, { Fragment } from "react";
import "./App.css";
import Home from "./components/Home";

const App = props => {
	return <Fragment>
		<div>
			<div className="uk-light uk-background-secondary uk-padding">
				<h2>Title</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<button className="uk-button uk-button-default">Button</button>
			</div>
		</div>
		<Home />
	</Fragment>;
};

export default App;
