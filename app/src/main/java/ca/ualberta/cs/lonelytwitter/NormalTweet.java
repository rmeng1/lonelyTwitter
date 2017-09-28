package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by rmeng1 on 9/13/17.
 */

/**
 * this class extends the Tweet class
 */


public class NormalTweet extends Tweet {
    public NormalTweet(String message){
        super (message);

    }

    /**
     * constructor for the normalTweet
     * @param date of tweet
     * @param message to be store in tweet
     *  @throws TweetTooLongException when the message is too long
     */
    public NormalTweet(String message, Date date){
        super(message,date);
    }

    /**
     *@return Boolean representing
     */

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
