package org.satwik.quizapp.Service;

import org.satwik.quizapp.Dao.QuestionDao;
import org.satwik.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //We can also write @Component here to handle its objects by spring
          //@Service is also an component. as it is service layer we mentioned as service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        //        questionDao.getAllQuestions();   //As we are using Spring data JPA there is no need
        //to define method in DAO layer for DB access. we have many inbuilt methods.
//        return questionDao.findAll();   //we can directly use this.

        try {      //Handling Exceptions
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
                    //Returning both data along with the status codes
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category)
    {
//        return questionDao.findByCategory(category);
        //As it is not an inbuilt method we need to declare this in the interface
        //not the body of function as it will be given by spring data
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question)
    {
        questionDao.save(question);
        return new ResponseEntity<>("Successfully added question to the database", HttpStatus.CREATED);
    }
}
