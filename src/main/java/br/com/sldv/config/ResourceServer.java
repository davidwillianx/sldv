package br.com.sldv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("br.com.sldv.config")
public class ResourceServer extends ResourceServerConfigurerAdapter {


    private UserDetailsService userDetails;


    @Bean
    public AuthenticationProvider authProvider(){

        final DaoAuthenticationProvider authProvider;

        authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetails);


        return authProvider;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder){
       authBuilder.authenticationProvider(authProvider());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .anyRequest().authenticated()
          .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and().csrf().disable();
    }
}
