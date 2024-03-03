package com.adina.dancestudio.exceptions;

public class CourseNotFoundException extends RuntimeException{
    private Long courseId;
    public CourseNotFoundException(String message, Long courseId) {
        super(message);
        this.courseId = courseId;
    }
    public Long getCourseId() {
        return courseId;
    }


}
