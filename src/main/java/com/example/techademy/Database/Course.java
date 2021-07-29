package com.example.techademy.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private String courseFee;
    private String courseResource;
    private String courseDesc;

    public Course() {
    }

    public Course(Long courseId, String courseName, String courseFee, String courseResource, String courseDesc) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.courseResource = courseResource;
        this.courseDesc = courseDesc;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public String getCourseResource() {
        return courseResource;
    }

    public void setCourseResource(String courseResource) {
        this.courseResource = courseResource;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFee='" + courseFee + '\'' +
                ", courseResource='" + courseResource + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                '}';
    }
}
