
/*
 * Tweet
 *  Version 1.0
 *  September 27 2017

 * Copyright 2017 Team X, CMPUT 301 , University of Alberta- All Rights Reserved.
 *  You may use distribute , or modify this code under terns and conditions of the Code of Student Behavior at University of Alberta.
 *   You can find the copy of the license in this project, Otherwise please contact contact@abc.ca.
 */

package ca.ualberta.cs.lonelytwitter;




import java.util.Date;

/**
 * Created by rmeng1 on 9/13/17.
 */


/**
 * Represents a tweet
 *
 * @ auther team X
 * @ version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 *
 * */

public abstract class Tweet implements Tweetable {



    private String message;
    private Date date;


    public Tweet (String message){
        this.date= new Date();
        this.message = message;


    }


    /**
     * constructs a Tweet object
     * @param message tweet message
     * @param date tweet date
     *
     * */
    public Tweet(String message, Date date) {
        this. date = date;
        this . message = message;
    }

    public String getMessage(){
        return message;

    }

    public Date getDate(){
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return date.toString() + "|" + message;
    }

/**
 * sets the tweet message
 *
 * @param message tweet message
 * @throws TweetTooLongException when message > 140
 * */
    public void setMessage(String message) throws TweetTooLongException {

        if (message.length()<140){
            this.message = message;

        }

        else {
            throw new TweetTooLongException();
        }
    }




    public abstract  Boolean isImportant();

}


