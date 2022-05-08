package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserRepository userRepo;

    public AuthenticationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping()
    public User getAuthenticatedUser(HttpServletRequest request, Principal principal) {
        if (principal == null)
            return null;

        request.getSession().setMaxInactiveInterval(600);
        User user = userRepo.findByEmail((String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("email")).get();
        System.out.println(user);
        return user;
    }

    @GetMapping("/isAuthenticated")
    public Boolean isAuthenticated(Principal principal) {
        return principal != null;
    }

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
}
