package daw.upm.models;

import org.springframework.data.repository.CrudRepository;


/**
 * Created by dani on 28/04/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {


    public User findById(long id);

    public Iterable<User> findAll();

}


