package org.satwik.quizapp.Dao;

import org.satwik.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

//    @Query(value = "SELECT * FROM question q Where q.category=:category ORDDER BY RANDOM() LIMIT :numQuestions",nativeQuery = true)
//    List<Question> findRandomQuestionsByCategory(String category, int numQuestions);
@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
List<Question> findRandomQuestionsByCategory(String category, int numQuestions);

}
//Here we can use class and JDBC but the code to implement those 7 steps are very lengthy
//To avoid that we already imported a package called Spring Data JPA. So we are utilizing
//its functionality.


