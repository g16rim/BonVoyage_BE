package com.ssafy.BonVoyage.auth.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Grade {
    Beginner("초보여행가"),
    Intermediate("중급여행가"),
    Advanced("마스터여행가");

    final private String grade;
    private Grade(String grade) {
        this.grade = grade;
    }


    public static Grade gradeOf(String grade) {
        for (Grade status : Grade.values()) {
            if (status.getGrade().equals(grade)) {
                return status;
            }
        }
        return null;
    }
}