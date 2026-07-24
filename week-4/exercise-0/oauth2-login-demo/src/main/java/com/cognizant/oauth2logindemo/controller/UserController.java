package com.cognizant.oauth2logindemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Login Demo";
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {

        Map<String, Object> user = new LinkedHashMap<>();

        user.put("Name", principal.getAttribute("name"));
        user.put("Email", principal.getAttribute("email"));
        user.put("Verified", principal.getAttribute("email_verified"));
        user.put("Picture", principal.getAttribute("picture"));

        return user;
    }
}