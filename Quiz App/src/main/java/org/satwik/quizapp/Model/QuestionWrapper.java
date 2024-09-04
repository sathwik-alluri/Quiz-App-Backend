package org.satwik.quizapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper
    //We created this wrapper class because we want to give the user only the question and
    //its options only and not the correct answer or any other.
{
        private Integer id;
        private String questiontitle;
        private String option1;
        private String option2;
        private String option3;
        private String option4;

    public QuestionWrapper(Integer id,String questiontitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questiontitle = questiontitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
