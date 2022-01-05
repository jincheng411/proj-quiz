package com.example.quizzproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizType {
    private Integer id;
    private String name;
    private int difficulty;
    private int timeLimit;
    private String image;
    private String description;

    @Override
    public String toString() {
        return "QuizType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", timeLimit=" + timeLimit +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
