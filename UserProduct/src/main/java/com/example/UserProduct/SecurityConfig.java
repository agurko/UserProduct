package com.example.UserProduct;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/Users").permitAll() // Доступ без аутентификации
                .anyRequest().authenticated() // Остальные запросы требуют аутентификации
                .and()
                .formLogin()
                .loginPage("/login") // Страница входа
                .permitAll() // Доступ к странице входа без аутентификации
                .and()
                .logout()
                .permitAll(); // Доступ к выходу без аутентификации
        return http.build();
    }

    public AuthenticationManagerBuilder authConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser ("user").password("{noop}password").roles("USER") // Пользователь с ролью USER
                .and()
                .withUser ("admin").password("{noop}admin").roles("ADMIN"); // Пользователь с ролью ADMIN

        return auth; // Возвращаем объект AuthenticationManagerBuilder
    }


}


