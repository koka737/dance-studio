package com.adina.dancestudio.controller;

import com.adina.dancestudio.exceptions.ReservationNotFoundException;
import com.adina.dancestudio.exceptions.StudentNotFoundException;
import com.adina.dancestudio.models.dtos.ReservationDTO;
import com.adina.dancestudio.models.dtos.StudentDTO;
import com.adina.dancestudio.models.entities.Student;
import com.adina.dancestudio.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentsById(@PathVariable("id") Long students_id){
            return studentService.getStudentsById(students_id);
    }

   /* @GetMapping("/{id}/firstName")
    public ResponseEntity<List<String>> getStudentsFirstNameByStudentId(@PathVariable Long studentId) {
        List<String> firstName = studentService.getStudentsFirstNameByStudentId(studentId);

        if (firstName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(firstName);
    }

    @GetMapping("/{id}/lastName")
    public ResponseEntity<List<String>> getStudentsLastNameByStudentId(@PathVariable Long studentId) {
        List<String> lastName = studentService.getStudentsFirstNameByStudentId(studentId);

        if (lastName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(lastName);
    }
    @GetMapping("/{id}/age")
    public ResponseEntity<List<Integer>> getStudentsAgeByStudentId(@PathVariable Long studentId) {
        List<Integer> age = studentService.getStudentsAgeByStudentId(studentId);

        if (age.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(age);
    }
    @GetMapping("/{id}/gender")
    public ResponseEntity<List<String>> getStudentsGenderByStudentId(@PathVariable Long studentId) {
        List<String> gender = studentService.getStudentsGenderByStudentId(studentId);

        if (gender.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(gender);
    }
    @GetMapping("/{id}/phoneNumber")
    public ResponseEntity<List<Integer>> getStudentsPhoneNumberByStudentId(@PathVariable Long studentId) {
        List<Integer> phoneNumber = studentService.getStudentsPhoneNumberByStudentId(studentId);

        if (phoneNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no age range found
        }

        return ResponseEntity.ok(phoneNumber);
    }*/


//create a new student
    @PostMapping("/")
    public ResponseEntity<?> createStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
    try {
        studentService.createStudent(studentDTO);

        String message = String.format("Student with ID %d was created", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }catch(ReservationNotFoundException e){
        String errorMessage = "Wrong request!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}

    // Get all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    // Update student
    @PutMapping("/{id}/update")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(id, student);
            if (updatedStudent == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedStudent);
        } catch (StudentNotFoundException e) {
            // Construct a custom error message
            String errorMessage = String.format("Student with ID %d can't be updated", id);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    // Delete student by ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFoundException e) {
            Long studentId = e.getStudentId();
            // Construct a custom error message
            String errorMessage = String.format("Student with ID %d was not found", studentId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
