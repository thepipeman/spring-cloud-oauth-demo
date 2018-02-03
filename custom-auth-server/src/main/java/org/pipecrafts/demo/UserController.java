package org.pipecrafts.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Aaron Rasing on 2/3/18.
 */
@RestController
public class UserController {

    /**
     * This endpoint authenticates users from other services
     * Spring Cloud Security uses it magic for this one
     * */
    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }

}
