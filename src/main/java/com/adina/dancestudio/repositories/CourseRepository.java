package com.adina.dancestudio.repositories;

import com.adina.dancestudio.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long courseId); // Corrected method name

    // Using the naming convention
    List<Course> findByCourseName(String courseName);
    List<Course> findByInstructorName(String instructorName);
    List<Course> findByAgeRange(Integer ageRange);
    List<Course> findByGenderFilter(String genderFilter);
    List<Course> findByCourseDuration(String courseDuration);
    List<Course> findByCourseDay(String courseDay);
    List<Course> findByCourseCapacity(Integer courseCapacity);

    // Using explicit JPQL
    @Query("SELECT c FROM courses c WHERE c.courseName = :courseName")
    List<Course> findCourseByNameJPQL(String courseName);

    @Query("SELECT c FROM courses c WHERE c.instructorName = :instructorName")
    List<Course> findByInstructorNameJPQL(String instructorName);

    @Query("SELECT c FROM courses c WHERE c.ageRange = :ageRange")
    List<Course> findByAgeRangeJPQL(Integer ageRange);

    @Query("SELECT c FROM courses c WHERE c.genderFilter = :genderFilter")
    List<Course> findByGenderFilterJPQL(String genderFilter);

    @Query("SELECT c FROM courses c WHERE c.courseDuration = :courseDuration")
    List<Course> findByCourseDurationJPQL(String courseDuration);

    @Query("SELECT c FROM courses c WHERE c.courseDay = :courseDay")
    List<Course> findByCourseDayJPQL(String courseDay);

    @Query("SELECT c FROM courses c WHERE c.courseCapacity = :courseCapacity")
    List<Course> findByCourseCapacityJPQL(Integer courseCapacity);
}




