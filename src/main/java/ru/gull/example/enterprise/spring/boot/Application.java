package ru.gull.example.enterprise.spring.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.gull.example.enterprise.spring.boot.model.zp.ZPResume;
import ru.gull.example.enterprise.spring.boot.repositories.ResumeRepository;
import ru.gull.example.enterprise.spring.boot.services.ZPResumeService;

import java.util.List;


@SpringBootApplication
public class Application {
    private Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(ResumeRepository repository, ZPResumeService resumeService) {
        return args -> {
            log.info("Loading resumes from zarplata.ru");
            // loading
            List<ZPResume> resumes = resumeService.loadLatestResumes();
            // saving
            resumes.stream()
                .map(ZPResume::asResume)
                .forEach(repository::save);
            // flushing
            repository.flush();
            log.info("Loading completed");
        };
    }
}
