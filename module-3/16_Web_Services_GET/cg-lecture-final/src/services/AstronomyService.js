import axios from 'axios';

const http = axios.create({
    baseURL: "https://api.nasa.gov"
});

const apiKey = "DEMO_KEY";

export default {

    getAstronomyPictureOfTheDay() {
        const url = "/planetary/apod?api_key=" + apiKey;
        return http.get(url);
    },

    getRandomImages(count) {
        const url = "/planetary/apod?api_key="+apiKey+"&count=" + count;
        return http.get(url);
    }

}

