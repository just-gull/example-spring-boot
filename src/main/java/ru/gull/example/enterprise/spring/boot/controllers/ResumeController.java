package ru.gull.example.enterprise.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gull.example.enterprise.spring.boot.model.Resume;
import ru.gull.example.enterprise.spring.boot.repositories.ResumeRepository;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @RequestMapping("/all")
    public List<Resume> all() {
        return resumeRepository.findAll();
    }

    @RequestMapping("/search")
    public List<Resume> search(@RequestParam("query") String query) {
        return resumeRepository.findByJobTitleContainingIgnoreCase(query);
    }
}
