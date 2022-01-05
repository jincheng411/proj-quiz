package com.example.quizzproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private Integer id;
    private Integer submissionId;
    private Integer questionId;
    private Integer selectId;
    private Integer answerId;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", submissionId=" + submissionId +
                ", questionId=" + questionId +
                ", selectId=" + selectId +
                ", answerId=" + answerId +
                '}';
    }
}
