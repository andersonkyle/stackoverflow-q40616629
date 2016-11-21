package com.example.stackoverflow;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "post")
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String sourceUrl;

    private String title;

    @Column(name = "published_on", columnDefinition = "TIMESTAMP NULL")
    private LocalDateTime publishedOn;

    @Column(name = "edited_on", columnDefinition = "TIMESTAMP NULL")
    private LocalDateTime editedOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDateTime publishedOn) {
        this.publishedOn = publishedOn;
    }

    public LocalDateTime getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(LocalDateTime editedOn) {
        this.editedOn = editedOn;
    }
}
