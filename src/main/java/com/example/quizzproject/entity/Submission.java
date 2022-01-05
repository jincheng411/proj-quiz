package com.example.quizzproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    private Integer id;
    private Integer userId;
    private Integer quizTypeId;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer isPassed;

    @Override
    public String toString() {
        return "Submission{" +
                "id=" + id +
                ", userId=" + userId +
                ", quizTypeId=" + quizTypeId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isPassed=" + isPassed +
                '}';
    }
}
