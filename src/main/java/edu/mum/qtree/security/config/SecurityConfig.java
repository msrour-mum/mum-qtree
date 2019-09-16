package edu.mum.qtree.security.config;

import edu.mum.qtree.security.jwt.JwtSecurityConfigurer;
import edu.mum.qtree.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin").permitAll()
                .antMatchers("/auth/signup").permitAll()
                //remove
                .antMatchers("/auth/**").permitAll()
//                .antMatchers("/Answer/**").permitAll()
//                .antMatchers("/Comment/**").permitAll()
//                .antMatchers("/Questions/**").permitAll()
//                .antMatchers("/Statistics/**").permitAll()
//                .antMatchers("/users/**").permitAll()
//                .antMatchers("/Vote/**").permitAll()
//                .antMatchers("/*/**").permitAll()
                //end remove
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/vehicles/**").permitAll()
                //.antMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("1")
                //.antMatchers(HttpMethod.GET, "/v1/vehicles/**").permitAll()
                .antMatchers("/Question/**").permitAll()
                .antMatchers("/Statistics/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .apply(new JwtSecurityConfigurer(jwtTokenProvider));
        //@formatter:on
    }


}