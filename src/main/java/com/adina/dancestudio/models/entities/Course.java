package com.adina.dancestudio.models.entities;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity(name="courses")
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "course_id")
    private Long courseId;

    @NotNull
    @Column(name = "course_name")
    private String courseName;

    @NotNull
    @Column(name = "instructor_name")
    private String instructorName;

    @NotNull
    @Column(name = "age_range")
    private Integer ageRange;

    @NotNull
    @Column(name = "gender_filter")
    private String genderFilter;

    @NotNull
    @Column(name = "course_duration")
    private String courseDuration;

    @NotNull
    @Column(name = "course_day")
    private String courseDay;

    @NotNull
    @Column(name = "course_capacity")
    private Integer courseCapacity;

    @OneToOne(mappedBy = "course")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

    public Course(Long courseId, String courseName, String instructorName, Integer ageRange, String genderFilter, String courseDuration, String courseDay, Integer courseCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.ageRange = ageRange;
        this.genderFilter = genderFilter;
        this.courseDuration = courseDuration;
        this.courseDay = courseDay;
        this.courseCapacity = courseCapacity;
    }

    public Course() {

    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Integer getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Integer ageRange) {
        this.ageRange = ageRange;
    }

    public String getGenderFilter() {
        return genderFilter;
    }

    public void setGenderFilter(String genderFilter) {
        this.genderFilter = genderFilter;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public Integer getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }
}
