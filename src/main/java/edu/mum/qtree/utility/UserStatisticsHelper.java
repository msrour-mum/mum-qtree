package edu.mum.qtree.utility;

import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.Vote;

public class UserStatisticsHelper {
    public int getUserReputationsByQuestions(User user){
        int numOfQuestion = 0;
        for(Question q : user.getQuestions()){
            if(q.getAnswers().size() >= 3) numOfQuestion ++ ;
        }
        return  ((numOfQuestion / 3)*10) ;
    }
    public int getUserReputationByAnswers(User user){
        int numOfAnswers =0 ;
        for (Answer a: user.getAnswers()){
            int positiveVotes =0 ;
            int negativeVotes = 0 ;
            if (a.getVotes().size()>= 3){
                for (Vote v : a.getVotes()){
                    if(v.isLike()) positiveVotes++ ;
                    else negativeVotes++ ;
                }
                if ((positiveVotes / negativeVotes) >= 5) numOfAnswers++ ;
            }
        }
        return ((numOfAnswers/2)*10) ;
    }
}
