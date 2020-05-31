import api from "./api"

const list = async () => {
	let films = [];

	try {
		const query = await api.film.list();
		films = query.data;
	} catch (error) {
		console.error(error);
	}

	return films;
};

const add = async film => {
	await api.film.add(film);
};

export default {
	list,
	add
};
