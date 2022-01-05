package com.example.quizzproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    private Integer id;
    private Integer questionId;
    private String description;
    private Integer isAnswer;

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", description='" + description + '\'' +
                ", isAnswer=" + isAnswer +
                '}';
    }
}
