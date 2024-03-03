package com.adina.dancestudio.exceptions;

public class TeacherNotFoundException extends RuntimeException{
    private Long teacherId;
    public TeacherNotFoundException(String message, Long teacherId) {
        super(message);
        this.teacherId = teacherId;
    }
    public Long getTeacherId() {
        return teacherId;
    }
}

