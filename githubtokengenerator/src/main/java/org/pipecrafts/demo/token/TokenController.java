package org.pipecrafts.demo.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aaron Rasing on 2/1/18.
 */
@Controller
@EnableOAuth2Sso
public class TokenController extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContext clientContext;

    @RequestMapping("/")
    public String loadHome(){
        return "home";
    }

    @RequestMapping("/token")
    public String loadToken(Model model){
        OAuth2AccessToken t = clientContext.getAccessToken();
        System.out.println("Token : " + t.getValue());
        model.addAttribute("token", t.getValue());

        return "token";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}
