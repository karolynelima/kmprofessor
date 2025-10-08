package com.kmprofessor.service;

import com.kmprofessor.domain.Professor;
import com.kmprofessor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Professor registerProfessor(Professor professor) {
        // O campo na entidade é passwordHash, então o getter gerado pelo Lombok é getPasswordHash()
        professor.setPasswordHash(passwordEncoder.encode(professor.getPasswordHash()));
        return professorRepository.save(professor);
    }

    public Optional<Professor> findProfessorByEmail(String email) {
        return professorRepository.findByEmail(email);
    }
}
