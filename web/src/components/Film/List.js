import React, { useState, useEffect } from "react";
import services from "../../services";
import Item from "./Item";

const List = props => {
	const [films, setFilms] = useState([]);

	useEffect(() => {
		const fetchData = async () => {
			const _films = await services.film.list();
			setFilms(_films);
		};
		fetchData();
	}, []);

	return (
		<div>
			{films.map(film => (
				<Item key={film.id} film={film} />
			))}
		</div>
	);
};

export default List;
