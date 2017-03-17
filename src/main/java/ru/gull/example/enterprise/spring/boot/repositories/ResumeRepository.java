package ru.gull.example.enterprise.spring.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gull.example.enterprise.spring.boot.model.Resume;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByJobTitleContainingIgnoreCase(String query);
}
