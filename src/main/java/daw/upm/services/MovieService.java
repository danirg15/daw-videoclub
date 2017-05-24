package daw.upm.services;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by dani on 08/05/2017.
 */
@Service
public class MovieService {

    /**
     * Fake implentation
     * @param keyword
     */
    public static void find(String keyword) {
        final String endpoint = "https://jsonplaceholder.typicode.com/albums";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class);

        System.out.println(result);
    }

}
