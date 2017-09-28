package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by rmeng1 on 9/13/17.
 */

/**
 *the class is extends Tweet class
 */

public class ImportantTweet extends Tweet {

    /**
     * @param message to pass the tweet
     * @throws TweetTooLongException when message is too long
     */
    public ImportantTweet(String message){
        super(message);
    }
    public ImportantTweet(String message, Date date){
        super (message,date);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }


}
