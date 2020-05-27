import React from "react";

const Item = props => {
	const { film } = props;

	return (
		<div>{film.title}</div>
	);
};

export default Item;
