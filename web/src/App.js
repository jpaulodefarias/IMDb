import React from "react";
import "./App.css";

import { BrowserRouter, Switch, Route } from "react-router-dom";

import Menu from "./components/Menu";
import Pages from "./components/Pages";

const App = props => (
	<BrowserRouter>
		<Menu />
		<Switch>
			<Route exact path="/">
				<Pages.Home />
			</Route>
			<Route exact path="/film/form">
				<Pages.Film.Form />
			</Route>
			<Route exact path="/evaluation/:filmId">
				<Pages.Evaluation />
			</Route>
		</Switch>
	</BrowserRouter>
);

export default App;
