package com.adina.dancestudio.service;
import com.adina.dancestudio.models.dtos.CourseDTO;
import com.adina.dancestudio.models.entities.Course;
import com.adina.dancestudio.models.entities.Student;
import com.adina.dancestudio.repositories.CourseRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public CourseDTO findById(Long courseId){
        Course course = courseRepository.getReferenceById(courseId);
        return convertToDTO(course);
    }
    public void createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setInstructorName(courseDTO.getInstructorName());
        course.setAgeRange(courseDTO.getAgeRange());
        course.setGenderFilter(courseDTO.getGenderFilter());
        course.setCourseDuration(courseDTO.getCourseDuration());
        course.setCourseDay(courseDTO.getCourseDay());
        course.setCourseCapacity(courseDTO.getCourseCapacity());

        courseRepository.save(course);
    }
    
    public List<CourseDTO> findAllCourses(){
        List<Course> courses;
        courses = courseRepository.findAll();

        return courses.stream()
                .peek(course-> Hibernate.initialize(course.getCourseName()))
                .map(this::convertToDTO)
                .toList();
    }

    public CourseDTO convertToDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setInstructorName(course.getInstructorName());
        courseDTO.setAgeRange(course.getAgeRange());
        courseDTO.setGenderFilter(course.getGenderFilter());
        courseDTO.setCourseDuration(course.getCourseDuration());
        courseDTO.setCourseDay(course.getCourseDay());
        courseDTO.setCourseCapacity(course.getCourseCapacity());

        return courseDTO;
    }
    public List<String> getCourseByName(String courseName){
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(Course::getCourseName) // Extracting the name of each course
                .peek(Hibernate::initialize) // Initializing lazy-loaded properties if any
                .collect(Collectors.toList());
    }
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()) {
            return null;
        }

        Course existingCourse = optionalCourse.get();
        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setInstructorName(updatedCourse.getInstructorName());
        existingCourse.setAgeRange(updatedCourse.getAgeRange());
        existingCourse.setGenderFilter(updatedCourse.getGenderFilter());
        existingCourse.setCourseDuration(updatedCourse.getCourseDuration());
        existingCourse.setCourseDay(updatedCourse.getCourseDay());
        existingCourse.setCourseCapacity(updatedCourse.getCourseCapacity());

        return courseRepository.save(existingCourse);
    }
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    /*public List<String> findByInstructorName(Long courseId) {
        // Find the course by ID
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return instructor name
        return List.of(course.getInstructorName());
    }

    public List<Integer> findByAgeRange(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return age range
        return List.of(course.getAgeRange());

    }

    public List<String> findByGenderFilter(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return age range
        return List.of(course.getGenderFilter());

    }

    public List<String> findByCourseDuration(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return age range
        return List.of(course.getCourseDuration());

    }

    public List<String> findByCourseDay(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return age range
        return List.of(course.getCourseDay());

    }

    public List<Integer> findByCourseCapacity(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            // If course not found, return empty list
            return List.of();
        }
        // Extract and return age range
        return List.of(course.getCourseCapacity());

    }*/
}
