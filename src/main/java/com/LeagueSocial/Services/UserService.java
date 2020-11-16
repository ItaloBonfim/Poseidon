package com.LeagueSocial.Services;

import com.LeagueSocial.Security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSpringSecurity Authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }
}
