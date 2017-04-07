package daw.upm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SpringApp extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

}