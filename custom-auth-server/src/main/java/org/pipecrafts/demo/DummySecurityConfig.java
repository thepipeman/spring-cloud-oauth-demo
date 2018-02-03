package org.pipecrafts.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by Aaron Rasing on 2/3/18.
 */
@Configuration
public class DummySecurityConfig extends GlobalAuthenticationConfigurerAdapter{

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("dummyuser1")
                .password("password")
                .roles("USER")
                .and()
                .withUser("dummyuser2")
                .password("password")
                .roles("USER", "OPERATOR");
    }

}
