package com.udacity.jwdnd.course1.cloudstorage.config;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.service.SuperDuperAuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SuperDuperSecurityConfiguration extends WebSecurityConfigurerAdapter {
  private SuperDuperAuthenticationService authenticationService;

  public SuperDuperSecurityConfiguration(SuperDuperAuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(this.authenticationService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/signup","/css/**","/js/**").permitAll().anyRequest().authenticated();
    http.formLogin().loginPage("/login").permitAll();
    http.formLogin().defaultSuccessUrl("/home",true).failureUrl("/login?error")
        .and().logout().invalidateHttpSession(true).clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
  }
}

/* http.authorizeRequests().antMatchers("/signup", "/login", "/css/**", "/js/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login?logout");;
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home", true);
    }
* */