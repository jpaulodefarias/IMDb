import React, { Fragment } from 'react';

const App = props => {
	return <Fragment>
		<div class="uk-child-width-1-2@s" uk-grid>
			<div>
				<div class="uk-light uk-background-secondary uk-padding">
					<h3>Light</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					<button class="uk-button uk-button-default">Button</button>
				</div>
			</div>
			<div>
				<div class="uk-dark uk-background-muted uk-padding">
					<h3>Dark</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					<button class="uk-button uk-button-default">Button</button>
				</div>
			</div>
		</div>
	</Fragment>;
};

export default App;
