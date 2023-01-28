package com.prmn.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Report implements Serializable {

    private long id;
    private String authorName;
    private String title;
    private String details;
    private Timestamp postedAt;

    public Report() {
        setId(1969L);
        setAuthorName("aaaaaaaaaaa");
        setTitle("bbbbbbbbb");
        setDetails("cccccc");
        setPostedAt(Timestamp.valueOf(LocalDateTime.now()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Timestamp postedAt) {
        this.postedAt = postedAt;
    }
}
