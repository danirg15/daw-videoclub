package daw.upm;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().anyRequest().permitAll(); //authenticated();
//        http.formLogin().loginPage("/login").usernameParameter("username")
//                .passwordParameter("password").defaultSuccessUrl("/home")
//                .failureUrl("/login?error").permitAll();
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
//                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("p1")
                .roles("USER");
    }
}