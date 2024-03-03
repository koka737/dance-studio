package com.adina.dancestudio.controller;
import com.adina.dancestudio.exceptions.CourseNotFoundException;
import com.adina.dancestudio.exceptions.StudentNotFoundException;
import com.adina.dancestudio.models.dtos.CourseDTO;

import com.adina.dancestudio.models.dtos.StudentDTO;
import com.adina.dancestudio.models.entities.Course;
import com.adina.dancestudio.models.entities.Reservation;
import com.adina.dancestudio.models.entities.Student;
import com.adina.dancestudio.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable("id") Long courseId){
        return courseService.findById(courseId);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses(){
        List<CourseDTO> course = courseService.findAllCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{courseName}")
    public ResponseEntity<List<String>> getCourseByName(@PathVariable String courseName) {
        List<String> courses = courseService.getCourseByName(courseName);

        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no courses found
        }

        return ResponseEntity.ok(courses); // Return the list of course names
    }
    @PostMapping("/")
    public ResponseEntity<?> createCourse(@PathVariable Integer id, @RequestBody CourseDTO courseDTO){
        try {
            courseService.createCourse(courseDTO);

            String message = String.format("Course with ID %d was created", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }catch(CourseNotFoundException e){
            String errorMessage = "Wrong request!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Object> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(Long.valueOf(id), course);
            if (updatedCourse == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedCourse);
        } catch (CourseNotFoundException e) {
            // Construct a custom error message
            String errorMessage = String.format("Course with ID %d can't be updated", id);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (CourseNotFoundException e) {
            Long courseId = e.getCourseId();
            // Construct a custom error message
            String errorMessage = String.format("Course with ID %d was not found", courseId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
   /* @GetMapping("/{courseId}/{instructorName}")
    public ResponseEntity<List<String>> getInstructorNameByCourseId(@PathVariable Long courseId) {
        List<String> instructorName = courseService.getInstructorNameByCourseId(courseId);

        if (instructorName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no instructors found
        }

        return ResponseEntity.ok(instructorName); // Return the list of instructor names
    }

    @GetMapping("/{courseId}/ageRange")
    public ResponseEntity<List<Integer>> getAgeRange(@PathVariable Long courseId) {
        List<Integer> ageRange = courseService.getAgeRange(courseId);

        if (ageRange.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(ageRange); // Return the list of age ranges
    }

    @GetMapping("/{courseId}/genderFilter")
    public ResponseEntity<List<String>> getGenderFilter(@PathVariable Long courseId) {
        List<String> genderFilter = courseService.getGenderFilter(courseId);

        if (genderFilter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(genderFilter);
    }

    @GetMapping("/{courseId}/courseDuration")
    public ResponseEntity<List<String>> getCourseDuration(@PathVariable Long courseId) {
        List<String> courseDuration = courseService.getCourseDuration(courseId);

        if (courseDuration.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(courseDuration);
    }
    @GetMapping("/{courseId}/courseDay")
    public ResponseEntity<List<String>> getCourseDay(@PathVariable Long courseId) {
        List<String> courseDay = courseService.getCourseDay(courseId);

        if (courseDay.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(courseDay);
    }

    @GetMapping("/{courseId}/courseCapacity")
    public ResponseEntity<List<Integer>> getCourseCapacity(@PathVariable Long courseId) {
        List<Integer> courseCapacity = courseService.getCourseCapacity(courseId);

        if (courseCapacity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(courseCapacity);
    }*/


}
