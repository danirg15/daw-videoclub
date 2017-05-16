package daw.upm;

import daw.upm.models.User;
import daw.upm.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DatabaseLoader {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
        // User #1: user:user, rol "USER"
        GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
        userRepository.save(new User("user", "user", "User", "user", "user@localhost.dev", Arrays.asList(userRoles)));

        // User #2: root:root, rol "USER/ADMIN"
        GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN") };
        userRepository.save(new User("root","root", "Root", "Root", "root@localhost.dev", Arrays.asList(adminRoles)));
    }
}
