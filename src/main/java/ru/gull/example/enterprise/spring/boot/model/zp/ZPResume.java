package ru.gull.example.enterprise.spring.boot.model.zp;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gull.example.enterprise.spring.boot.model.Resume;

import java.util.Map;

public class ZPResume {
    private Long id;
    @JsonProperty("header")
    private String jobTitle;
    private String fullName;
    private String salary;
    private String photoURL;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @JsonProperty("contact")
    private void unpackFullName(Map<String, Object> values) {
        fullName = unpackStringValue(values, "name");
    }

    @JsonProperty("photo")
    private void unpackPhoto(Map<String, Object> values) {
        photoURL = unpackStringValue(values, "url");
    }

    private String unpackStringValue(Map<String, Object> values, String key) {
        if (values.containsKey(key) && values.get(key) != null) {
            return ((String) values.get(key)).trim();
        }
        return null;
    }

    public Resume asResume() {
        Resume resume = new Resume();
        resume.setId(this.id);
        resume.setFullName(this.fullName);
        resume.setJobTitle(this.jobTitle);
        resume.setSalary(this.salary);
        resume.setPhotoURL(this.photoURL);
        return resume;
    }
}
