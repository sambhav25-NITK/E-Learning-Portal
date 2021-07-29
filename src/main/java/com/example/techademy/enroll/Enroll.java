package com.example.techademy.enroll;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(EnrollId.class)
public class Enroll {

    @Id
    private Long enrolledUserId;
    @Id
    private Long enrolledCourseId;

    public Enroll() {
    }

    public Enroll(Long enrolledUserId, Long enrolledCourseId) {
        this.enrolledUserId = enrolledUserId;
        this.enrolledCourseId = enrolledCourseId;
    }

    public Long getEnrolledUserId() {
        return enrolledUserId;
    }

    public void setEnrolledUserId(Long enrolledUserId) {
        this.enrolledUserId = enrolledUserId;
    }

    public Long getEnrolledCourseId() {
        return enrolledCourseId;
    }

    public void setEnrolledCourseId(Long enrolledCourseId) {
        this.enrolledCourseId = enrolledCourseId;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "enrolledUserId=" + enrolledUserId +
                ", enrolledCourseId=" + enrolledCourseId +
                '}';
    }
}