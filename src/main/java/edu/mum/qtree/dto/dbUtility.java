package edu.mum.qtree.dto;

import edu.mum.qtree.models.entities.*;

import java.sql.Timestamp;

public class dbUtility {

    public static Timestamp Now()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return  new Timestamp(timestamp.getTime());
    }

    public static User quickUser(int id)
    {
        User u=new User();
        u.setId(id);
        return  u;
    }
    public static TextStatus quickTextStatus(int id)
    {
        TextStatus status=new TextStatus();
        status.setId((short) id);
        return  status;
    }

    public static Question quickQuestion(long id)
    {
        Question obj=new Question();
        obj.setId(id);
        return obj;
    }
    public static Answer quickAnswer(long id)
    {
        Answer obj=new Answer();
        obj.setId(id);
        return obj;
    }
    public static Comment quickComment(long id)
    {
        Comment obj=new Comment();
        obj.setId(id);
        return obj;
    }
}
