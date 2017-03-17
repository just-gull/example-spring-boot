package ru.gull.example.enterprise.spring.boot.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.gull.example.enterprise.spring.boot.model.zp.ZPEndpointResponse;
import ru.gull.example.enterprise.spring.boot.model.zp.ZPResume;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.List;

@Service
public class ZPResumeService {

    private static final String RESUME_URL = "https://api.zp.ru/v1/resumes/?geo_id=1177&limit=50&state=1";

    private ObjectMapper mapper = new ObjectMapper();

    public List<ZPResume> loadLatestResumes() throws Exception {
        ZPEndpointResponse response = mapper.readValue(new URL(RESUME_URL), ZPEndpointResponse.class);
        return response.getResumes();
    }

    @PostConstruct
    public void init() {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
