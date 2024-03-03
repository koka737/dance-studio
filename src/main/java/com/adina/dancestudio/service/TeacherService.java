package com.adina.dancestudio.service;
import com.adina.dancestudio.models.dtos.TeacherDTO;
import com.adina.dancestudio.models.entities.Student;
import com.adina.dancestudio.models.entities.Teacher;
import com.adina.dancestudio.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public TeacherDTO getTeachersById(Long teacherId){
        Teacher teacher = teacherRepository.getReferenceById(teacherId);

        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName(teacher.getTeacherName());

        return teacherDTO;
    }
    public void createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherDTO.getTeacherName());

        teacherRepository.save(teacher);
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isEmpty()) {
            return null;
        }


        Teacher existingTeacher = optionalTeacher.get();
        existingTeacher.setTeacherName(updatedTeacher.getTeacherName());


        return teacherRepository.save(existingTeacher);
    }

    public void deleteTeacher(Long teacherId) {
        // Delete the student by ID
        teacherRepository.deleteById(teacherId);
    }

}
