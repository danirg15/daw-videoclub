package daw.upm.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by dani on 28/04/2017.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {


    public Movie findById(long id);

    public Iterable<Movie> findAll();

    public Movie findByTitle(String title);

}



