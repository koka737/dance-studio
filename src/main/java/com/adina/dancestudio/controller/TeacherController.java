package com.adina.dancestudio.controller;
import com.adina.dancestudio.exceptions.ReservationNotFoundException;
import com.adina.dancestudio.exceptions.TeacherNotFoundException;
import com.adina.dancestudio.models.dtos.TeacherDTO;

import com.adina.dancestudio.models.entities.Teacher;
import com.adina.dancestudio.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeachersById(@PathVariable("id") Long teacher_id){
        return teacherService.getTeachersById(teacher_id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTeacher(@PathVariable Integer id, @RequestBody TeacherDTO teacherDTO){
        try {
            teacherService.createTeacher(teacherDTO);

            String message = String.format("Teacher with ID %d was created", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }catch(ReservationNotFoundException e){
            String errorMessage = "Wrong request!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    // Get all teachers
    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }
    // Update teacher
    @PutMapping("/{id}")
    public Object updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        try {
            Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
            if (updatedTeacher == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedTeacher);
        }catch(TeacherNotFoundException e){
            Long teacherId = e.getTeacherId();
            // Construct a custom error message
            String errorMessage = String.format("Teacher with ID %d can't be updated", teacherId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }

    // Delete teacher by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        try {
            teacherService.deleteTeacher(id);
            return ResponseEntity.noContent().build();
        } catch (TeacherNotFoundException e) {
            Long teacherId = e.getTeacherId();
            // Construct a custom error message
            String errorMessage = String.format("Teacher with ID %d was not found", teacherId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

