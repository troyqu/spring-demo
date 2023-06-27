package com.troyqu.springbootdemo.springcloudgateway.controller;

import com.troyqu.springbootdemo.springcloudgateway.config.PBKDF2Encoder;
import com.troyqu.springbootdemo.springcloudgateway.model.AuthRequest;
import com.troyqu.springbootdemo.springcloudgateway.model.AuthResponse;
import com.troyqu.springbootdemo.springcloudgateway.service.UserService;
import com.troyqu.springbootdemo.springcloudgateway.util.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class AuthenticationREST {

    private JWTUtil jwtUtil;
    private PBKDF2Encoder passwordEncoder;
    private UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest ar) {
        return userService.findByUsername(ar.getUsername())
                .filter(userDetails -> passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }

}
