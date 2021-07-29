package com.example.techademy.enroll;

public class EnrollBean {
    private String enrolledCourseName;

    public EnrollBean() {
    }

    public EnrollBean(String enrolledCourseName) {
        this.enrolledCourseName = enrolledCourseName;
    }

    public String getEnrolledCourseName() {
        return enrolledCourseName;
    }

    public void setEnrolledCourseName(String enrolledCourseName) {
        this.enrolledCourseName = enrolledCourseName;
    }

    @Override
    public String toString() {
        return "EnrollBean{" +
                "enrolledCourseName='" + enrolledCourseName + '\'' +
                '}';
    }
}
