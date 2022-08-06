import axios from 'axios';

export default {
    searchMovies(searchTerm) {
        const url = "/searchMovie/" + searchTerm;
        return axios.get(url);
    }
}