package org.satwik.quizapp.Service;

import org.satwik.quizapp.Model.*;
import org.satwik.quizapp.Dao.QuestionDao;
import org.satwik.quizapp.Dao.QuizDao;
import org.satwik.quizapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService
{
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;    //As it is responsible for fetching questions we imported this.

    public ResponseEntity<String> createQuiz(String category, int numQuestions, String title)
    {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Successfully Created Quiz", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<QuestionWrapper>();
        for(Question q : questions)
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses)
    {
//        Quiz quiz= quizDao.getById(id).get(); //By putting .get() here there is no need to put optional<>
//                     //at the variable
         Optional<Quiz> quiz = quizDao.findById(id);
         List<Question> questions = quiz.get().getQuestions();
         int right=0;
         int i=0;
         for(Response r : responses)
         {
             if(r.getResponse().equals(questions.get(i).getRightanswer()))
             {
                 right++;
             }
             i++;
         }
         return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
