package com.example.techademy.enroll;

import java.io.Serializable;

public class EnrollId implements Serializable {
    private Long enrolledUserId;
    private Long enrolledCourseId;

    public EnrollId() {
    }

    public EnrollId(Long enrolledUserId, Long enrolledCourseId) {
        this.enrolledUserId = enrolledUserId;
        this.enrolledCourseId = enrolledCourseId;
    }
}
