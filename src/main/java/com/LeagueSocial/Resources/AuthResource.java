package com.LeagueSocial.Resources;

import com.LeagueSocial.Resources.Profile.RefreshTokenResource;
import com.LeagueSocial.Security.JWTUtil;
import com.LeagueSocial.Security.UserSpringSecurity;
import com.LeagueSocial.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource implements RefreshTokenResource {

    @Autowired private JWTUtil jwtUtil;

    @Override
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {

        UserSpringSecurity userSS = UserService.Authenticated();
        String token = jwtUtil.GenerationToken(userSS.getUsername());

        response.addHeader("Authorization","Bearer " + token);

        return ResponseEntity.noContent().build();
    }
}
