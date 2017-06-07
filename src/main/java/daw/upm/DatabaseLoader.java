package daw.upm;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;
import daw.upm.models.User;
import daw.upm.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    private void initDatabase() {
        if(userRepository.count() == 0) {
            // User #1: user:user, rol "USER"
            GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
            userRepository.save(new User("user", "user", "User", "user", "user@localhost.dev", Arrays.asList(userRoles)));

            // User #2: root:root, rol "USER/ADMIN"
            GrantedAuthority[] adminRoles = {new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")};
            userRepository.save(new User("root", "root", "Root", "Root", "root@localhost.dev", Arrays.asList(adminRoles)));
        }


        if(movieRepository.count() == 0) {
            //this.seedMoviesDatabase();
        }

    }


    private void seedMoviesDatabase() {
        try {
            String sql_file = System.getProperty("user.dir")+"/src/main/resources/static/data/movies.sql";
            String query = new String(Files.readAllBytes(Paths.get(sql_file)));

            String url = "jdbc:mysql://localhost:3306/daw-upm";
            Connection conn = DriverManager.getConnection(url,"daw-upm","daw-upm");
            Statement stmt = null;
            stmt = conn.createStatement();

            stmt.executeUpdate(query);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
