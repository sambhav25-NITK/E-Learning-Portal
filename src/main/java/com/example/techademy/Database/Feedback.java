package com.example.techademy.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;
    private Long userId;
    private String name;
    private String email;
    private String feed;

    public Feedback() {
    }

    public Feedback(Long feedbackId, Long userId, String name, String email, String feed) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.feed = feed;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", feed='" + feed + '\'' +
                '}';
    }
}
