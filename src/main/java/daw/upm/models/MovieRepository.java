package daw.upm.models;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Cacheable
    public Movie findById(long id);
    @Cacheable
    public Movie findByTitle(String title);


    public Iterable<Movie> findAll();
}



