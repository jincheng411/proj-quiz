package com.example.quizzproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    private Integer quizTypeId;
    private String description;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", quizTypeId=" + quizTypeId +
                ", description='" + description + '\'' +
                '}';
    }
}
