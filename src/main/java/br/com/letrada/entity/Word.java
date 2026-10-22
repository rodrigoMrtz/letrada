package br.com.letrada.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false, length = 50)
    private String word;
    @Column (nullable = false, length = 10)
    private String language;
    @Column (length = 50)
    private String category;
    @Column (length = 20)
    private String difficulty;
    @Column (nullable = false)
    private Boolean active = true;
    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist 
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Word(String word, String language, String category, String difficulty, Boolean active) {
        this.word = word;
        this.language = language;
        this.category = category;
        this.difficulty = difficulty;
        this.active = active;
    }
}
