import api from "./api"

const list = async () => {
	let evaluations = [];

	try {
		const query = await api.evaluation.list();
		evaluations = query.data;
	} catch (error) {
		console.error(error);
	}

	return evaluations;
};

const add = async evaluation => {
	try {
		await api.evaluation.add(evaluation);
	} catch (error) {
		console.error(error);
	}
};

export default {
	list,
	add
};
