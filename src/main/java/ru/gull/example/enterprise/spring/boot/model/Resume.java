package ru.gull.example.enterprise.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resume {
    @Id
    private Long id;
    private String jobTitle;
    private String fullName;
    private String salary;
    private String photoURL;

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSalary() {
        return salary;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
