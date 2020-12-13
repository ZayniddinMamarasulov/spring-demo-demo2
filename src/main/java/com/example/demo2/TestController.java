package com.example.demo2;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello, I AM DEMO APP");
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "This text is only available for authenticated users";
    }

    @GetMapping("/user")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }

    @PostMapping("message/{id}")
    public ResponseEntity message(@PathVariable Long id) {
        MessageDto dto = new MessageDto();
        dto.setId(id);
        dto.setMessage("Message from Demo2");
        return ResponseEntity.ok(dto);
    }
}
