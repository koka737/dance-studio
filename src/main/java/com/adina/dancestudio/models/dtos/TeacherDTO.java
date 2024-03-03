package com.adina.dancestudio.models.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherDTO {
    private String teacherName;

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
