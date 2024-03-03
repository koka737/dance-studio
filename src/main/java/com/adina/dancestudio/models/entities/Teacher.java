package com.adina.dancestudio.models.entities;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity(name = "teachers")
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="teacher_id")
    private Long teacherId;

    @NotNull
    @Column(name="teacher_name")
    private String teacherName;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public Teacher(Long teacher_id, String teacherName) {
        this.teacherId = teacher_id;
        this.teacherName = teacherName;

    }
    public Teacher(){
    }
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
