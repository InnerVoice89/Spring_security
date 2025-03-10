package ru.springsecuritynew.springsecuritynew.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.springsecuritynew.springsecuritynew.security.AuthProviderImpl;
import ru.springsecuritynew.springsecuritynew.services.PersonDetailsService;
import ru.springsecuritynew.springsecuritynew.services.RegistrationService;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

private final PersonDetailsService personDetailsService;

    public SecurityConfig(PersonDetailsService personDetailsService) {
        System.out.println("SecurityConfig initialized");
        this.personDetailsService = personDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login","/error","/auth/registration").permitAll()
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().hasAnyRole("USER","ADMIN")
//                        .anyRequest().authenticated()

                )
//                .authenticationProvider() // Используем кастомный AuthenticationProvider
                .formLogin(form -> form
                        .loginPage("/auth/login")  // Указываем кастомную страницу логина
                        .loginProcessingUrl("/process_login")  // URL для обработки формы
                        .usernameParameter("username")  // Параметр для имени пользователя
                        .passwordParameter("password")  // Параметр для пароля
                        .defaultSuccessUrl("/", true)  // Страница после успешной аутентификации
                        .failureUrl("/auth/login?error")  // Страница при ошибке аутентификации
                ).logout(logout->logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login"));

//                .httpBasic(httpBasic -> {});

        return http.build();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(personDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }


    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
