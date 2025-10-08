package com.kmprofessor.controller;

import com.kmprofessor.domain.Professor;
import com.kmprofessor.dto.LoginRequestDTO;
import com.kmprofessor.dto.LoginResponseDTO;
import com.kmprofessor.dto.RegisterRequestDTO;
import com.kmprofessor.service.ProfessorService;
import com.kmprofessor.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequest) {
        Professor professor = new Professor();
        professor.setName(registerRequest.getName());
        professor.setEmail(registerRequest.getEmail());
        // A senha do DTO é a senha pura (plain text)
        professor.setPasswordHash(registerRequest.getPassword());

        professorService.registerProfessor(professor);
        return ResponseEntity.ok("Professor registrado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        var professorOptional = professorService.findProfessorByEmail(loginRequest.getEmail());
        if (professorOptional.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), professorOptional.get().getPasswordHash())) {
            Professor professor = professorOptional.get();
            String token = jwtService.generateToken(professor.getEmail());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        return ResponseEntity.badRequest().body("Credenciais inválidas.");
    }
}
