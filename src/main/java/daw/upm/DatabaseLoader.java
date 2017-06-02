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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        //this.seedMoviesDatabase();
    }


    private  void seedMoviesDatabase() {
        String csvFile = System.getProperty("user.dir")+"/src/main/resources/static/data/movies.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);


                //Movie m = new Movie(data[10], Integer.parseInt(data[11]), null, data[6], data[5], data[1], data[7], data[8], data[3], Double.parseDouble(data[9]), Double.parseDouble(data[2]));

                Movie m = new Movie("abc", 123, null, "", "", "", "", "link", "", Double.parseDouble(data[9]), Double.parseDouble(data[2]));
                System.out.print(data[0]);


                //System.out.print(m.toString());

                //this.movieRepository.save(m);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
