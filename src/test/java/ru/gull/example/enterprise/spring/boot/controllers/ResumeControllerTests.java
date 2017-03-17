package ru.gull.example.enterprise.spring.boot.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.gull.example.enterprise.spring.boot.model.Resume;
import ru.gull.example.enterprise.spring.boot.repositories.ResumeRepository;
import ru.gull.example.enterprise.spring.boot.services.ZPResumeService;

import java.util.Arrays;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ResumeController.class)
public class ResumeControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ResumeRepository resumeRepository;

    @MockBean
    private ZPResumeService service;

    @Test
    public void allRequestShouldReturnAllResumes() throws Exception {
        given(resumeRepository.findAll())
            .willReturn(Arrays.asList(new Resume(), new Resume()));
        this.mvc.perform(get("/resume/all").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }
}
