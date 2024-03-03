package com.adina.dancestudio.exceptions;

public class StudentNotFoundException extends RuntimeException{
    private Long studentId;
    public StudentNotFoundException(String message, Long studentId) {
        super(message);
        this.studentId = studentId;
    }
    public Long getStudentId() {
        return studentId;
    }
}
