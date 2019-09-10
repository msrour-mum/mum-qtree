package edu.mum.qtree.services;

import edu.mum.qtree.models.Question;

import java.util.ArrayList;
import java.util.List;

public class ExampleService {



    public List<Question> getQuestions()
    {
        List<Question> questions = new ArrayList<>();

       questions.add(new Question(1, "q1"));
       questions.add(new Question(2, "q2"));
       questions.add(new Question(3, "q3"));
       questions.add(new Question(4, "q4"));
       questions.add(new Question(5, "q5"));

       return questions;

    }
}
