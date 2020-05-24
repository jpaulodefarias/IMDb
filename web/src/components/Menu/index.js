import React from "react";
import { NavLink } from "react-router-dom";
import logo from "../../resources/images/logo.png"

const Menu = props => (
	<nav className="uk-navbar-container uk-navbar uk-navbar-transparent uk-light">
		<div class="uk-navbar-left">
			<ul class="uk-navbar-nav">
				<li>
					<NavLink to="/">
						<img src={logo} alt="IMDb" width="100" draggable="false" />
					</NavLink>
				</li>
			</ul>
		</div>
		<div class="uk-navbar-right"></div>
	</nav>
);

export default Menu;
