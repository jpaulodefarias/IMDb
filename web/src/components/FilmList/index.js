import React, { useState, useEffect } from "react";
import services from "../../services";

const FilmList = props => {
	const [films, setFilms] = useState([]);

	useEffect(() => {
		const fetchData = async () => {
			const _films = await services.film.list();
			setFilms(_films);
		};
		fetchData();
	}, []);

	return (
		<ul>
			{films.map(item => (
				<li key={item.id}>
					{item.title}
				</li>
			))}
		</ul>
	);
};

export default FilmList;
