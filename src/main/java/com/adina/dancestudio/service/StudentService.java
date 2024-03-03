package com.adina.dancestudio.service;

import com.adina.dancestudio.models.dtos.StudentDTO;
import com.adina.dancestudio.models.entities.Student;
import com.adina.dancestudio.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentDTO getStudentsById(Long studentId){
        Student student = studentRepository.getReferenceById(studentId);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setGender(student.getGender());
        studentDTO.setAccountPassword(student.getAccountPassword());

        return studentDTO;
    }

    public void createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setGender(studentDTO.getGender());
        student.setAccountPassword(studentDTO.getAccountPassword());

        studentRepository.save(student);
    }

    public List<String> getStudentsFirstNameByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {

            return List.of();
        }

        return List.of(student.getFirstName());

    }

    public List<String> getStudentsLastNameByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {

            return List.of();
        }

        return List.of(student.getLastName());

    }
    public List<Integer> getStudentsAgeByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {

            return List.of();
        }

        return List.of(student.getAge());

    }

    public List<String> getStudentsGenderByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {

            return List.of();
        }

        return List.of(student.getGender());

    }
    public List<Integer> getStudentsPhoneNumberByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {

            return List.of();
        }

        return List.of(student.getPhoneNumber());

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student updateStudent(Long studentId, Student updatedStudent) {
        // Check if the student with the given ID exists
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            return null; // Return null if student not found
        }

        // Update the student details
        Student existingStudent = optionalStudent.get();
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setAccountPassword(updatedStudent.getAccountPassword());

        // Save and return the updated student
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long studentId) {
        // Delete the student by ID
        studentRepository.deleteById(studentId);
    }


}