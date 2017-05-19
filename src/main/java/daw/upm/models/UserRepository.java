package daw.upm.models;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Cacheable
    User findById(long id);

    @Cacheable
    User findByUsername(String username);

    // Si hay alguna actualizacion de user (adición/borrado/edición)
    // habría que usar @CacheEvict para evitar que se la cache de resultados
    // sirva valores antiguos.

    Iterable<User> findAll();
}


