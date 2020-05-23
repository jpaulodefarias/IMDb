import client from "./client";

const film = {
	list: () => client.get('/film')
};

export default {
	film
};
