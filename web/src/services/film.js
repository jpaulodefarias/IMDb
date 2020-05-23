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

export default {
	list
};
