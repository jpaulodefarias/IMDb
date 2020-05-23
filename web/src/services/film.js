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
	try {
		await api.film.add(film);
	} catch (error) {
		console.error(error);
	}
};

export default {
	list,
	add
};
