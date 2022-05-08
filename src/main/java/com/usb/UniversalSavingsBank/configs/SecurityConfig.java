package com.usb.UniversalSavingsBank.configs;

import com.usb.UniversalSavingsBank.services.CustomOidcUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;

    private final CustomOidcUserService customOidcUserService;


    public SecurityConfig(PasswordEncoder encoder, CustomOidcUserService customOidcUserService) {
        this.encoder = encoder;
        this.customOidcUserService = customOidcUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/", "/api/oauth/logout", "/api/auth/isAuthenticated", "/api/test").permitAll()
                .antMatchers("/api/about", "/api/finish-reg").authenticated()
                .and()
                .oauth2Login().defaultSuccessUrl("/finish-reg", true)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .exceptionHandling().authenticationEntryPoint(new EmrExceptionHandler());

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }

//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/hello", "api/oauth/logout");
//    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
