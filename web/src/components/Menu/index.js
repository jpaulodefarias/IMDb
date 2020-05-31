import React from "react";
import { Link } from "react-router-dom";
import logo from "../../resources/images/logo.png"

const Menu = props => (
	<nav className="uk-navbar-container uk-navbar uk-navbar-transparent uk-light">
		<div className="uk-navbar-left">
			<ul className="uk-navbar-nav">
				<li>
					<Link to="/">
						<img src={logo} alt="IMDb" width="100" draggable="false" />
					</Link>
				</li>
			</ul>
		</div>
		<div className="uk-navbar-right">
			<ul className="uk-navbar-nav">
				<li>
					<Link to="/film">
						<span className="uk-button uk-button-default uk-margin-small-right">Add New Film</span>
					</Link>
				</li>
			</ul>
		</div>
	</nav>
);

export default Menu;
