package org.satwik.quizapp.Controllers;

import org.satwik.quizapp.Model.Question;
import org.satwik.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    @ResponseBody           //used when we returning text rather than view
    public ResponseEntity<List<Question>> getAllQuestions()
    {
//        return "These are all your Questions!!";
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{categoryType}")
    @ResponseBody           //used when we returning text rather than view
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable("categoryType") String category)
    {
        return questionService.getAllQuestionsByCategory(category);
    }


    @PostMapping("addQuestion")
    //@ResponseBody
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {        //@RequestBody used to get the data sent from client in other forms
                // like Json to object.
        return questionService.addQuestion(question);
    }
}
