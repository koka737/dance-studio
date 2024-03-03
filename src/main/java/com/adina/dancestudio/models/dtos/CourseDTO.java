package com.adina.dancestudio.models.dtos;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {
    private String courseName;
    private String instructorName;
    private Integer ageRange;
    private String genderFilter;
    private String courseDuration;
    private String courseDay;
    private Integer courseCapacity;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setAgeRange(Integer ageRange) {
        this.ageRange = ageRange;
    }

    public void setGenderFilter(String genderFilter) {
        this.genderFilter = genderFilter;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }
}
