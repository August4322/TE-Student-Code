import axios from 'axios';

const http = axios.create({
    baseURL: "https://api.nasa.gov/"
}); 

export default {

    getAstronomyPictureOfTheDay() {
        const url = "planetary/apod?api_key=DEMO_KEY"
        return http.get(url)
    }

}