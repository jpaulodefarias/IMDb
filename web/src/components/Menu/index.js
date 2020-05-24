import React from "react";
import { NavLink } from "react-router-dom";
import logo from "../../resources/images/logo.png"

const Menu = props => (
	<nav className="uk-navbar-container uk-navbar uk-navbar-transparent uk-light">
		<div className="uk-navbar-left">
			<ul className="uk-navbar-nav">
				<li>
					<NavLink to="/">
						<img src={logo} alt="IMDb" width="100" draggable="false" />
					</NavLink>
				</li>
			</ul>
		</div>
		<div className="uk-navbar-right">
			<ul className="uk-navbar-nav">
				<li>
					<NavLink to="/film/form">
						<span className="uk-button uk-button-default uk-margin-small-right">Add New Film</span>
					</NavLink>
				</li>
			</ul>
		</div>
	</nav>
);

export default Menu;
