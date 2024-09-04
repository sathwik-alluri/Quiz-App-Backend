package org.satwik.quizapp.Model;


//Here one quiz can have multiple questions and one question can be present in multiple tables
//Hence it is an many-to-many relationship

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

}
