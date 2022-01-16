package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Integer createProfessor(Professor professor){
        professor.setId(null);
        Professor createdProfessor = professorRepository.save(professor);
        return createdProfessor.getId();
    }

    public Professor getProfessor(Integer id)
    {
        Optional<Professor> optional = professorRepository.findById(id);

        if(optional.isPresent())
            return optional.get();

        return null;
    }
}
