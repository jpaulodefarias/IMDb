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
	await api.evaluation.add(evaluation);
};

export default {
	list,
	add
};
