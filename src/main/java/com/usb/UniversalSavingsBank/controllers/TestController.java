package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Arrays;

@RestController
public class TestController {


//    private final TokenStore tokenStore;

//    @PostMapping("/api/oauth/logout")
//    public void revoke(HttpServletRequest request, HttpServletResponse response, Principal principal) {
//        SecurityContextHolder.clearContext();
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        for (Cookie cookie : request.getCookies()) {
//            cookie.setMaxAge(0);
//        }
//        try {
//            String authorization = request.getHeader("Authorization");
//            if (authorization != null && authorization.contains("Bearer")) {
//                String tokenValue = request.getCookies()[0].getValue();
//
//                OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
//                tokenStore.removeAccessToken(accessToken);
//
//                //OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(tokenValue);
//                OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
//                tokenStore.removeRefreshToken(refreshToken);
//            }
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Invalid access token");
//        }
//
//        return ResponseEntity.ok().body("Access token invalidated successfully");
//    }

    private final UserRepository userRepo;

    public TestController(TokenStore tokenStore, UserRepository userRepo) {
//        this.tokenStore = tokenStore;
        this.userRepo = userRepo;
    }

    @GetMapping("/api/user")
    public User getAuthenticatedUser(Principal principal) {
        if (principal == null)
            return null;
        User user = userRepo.findByEmail((String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("email")).get();
        System.out.println(user);
        return user;
    }

    @GetMapping(path = "/api/about")
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
