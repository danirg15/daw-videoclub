package daw.upm.services;

import daw.upm.models.Movie;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


@Service
public class MovieService {

    //API Docs: https://developers.themoviedb.org/3/movies
    private final static String api_key = "6634aff110ebd9bc66f41114c0897ab7";
    private final static String base_uri = "https://api.themoviedb.org/3";
    private final static String lang = "es-ES";


    private static HttpEntity<String> buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
    }

    /**
     * Buscar peliculas por nombre
     *
     * @param keyword
     */
    public static String find(String keyword) {
        String endpoint = base_uri + String.format("/search/movie?api_key=%s&language=%s&query=%s", api_key, lang, keyword);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, buildHeaders(), String.class);
        return result.getBody();
    }

    /**
     * Obtener todos los detalles de una pelicula
     *
     * @param movie_id
     */
    public static String getDetails(int movie_id) {
        String endpoint = base_uri + String.format("/movie/%s?api_key=%s&language=%s", movie_id, api_key, lang);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, buildHeaders(), String.class);
        return  result.getBody();
    }


    public static String movieDetails(String title) {
        String json = MovieService.find(title);
        HashMap<String, Object> data = JSONParser.parseJson(json, null);

        if(data.containsKey("results")) {
            ArrayList results = (ArrayList) data.get("results");

            if(results.size() > 0) {
                HashMap<String, Object> entry = (HashMap<String, Object>) results.get(0);
                return MovieService.getDetails((Integer) entry.get("id"));
            }
        }
        return null;
    }



}