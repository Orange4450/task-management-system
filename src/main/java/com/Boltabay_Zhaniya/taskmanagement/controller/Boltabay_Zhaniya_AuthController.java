package com.Boltabay_Zhaniya.taskmanagement.controller;
import com.Boltabay_Zhaniya.taskmanagement.dto.*;
import com.Boltabay_Zhaniya.taskmanagement.service.Boltabay_Zhaniya_AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Boltabay_Zhaniya_AuthController {

    private final Boltabay_Zhaniya_AuthService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Boltabay_Zhaniya_RegisterRequestDto dto) {

        service.register(dto);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Boltabay_Zhaniya_AuthResponseDto> login(@RequestBody Boltabay_Zhaniya_LoginRequestDto dto) {

        return ResponseEntity.ok(service.login(dto));
    }
}