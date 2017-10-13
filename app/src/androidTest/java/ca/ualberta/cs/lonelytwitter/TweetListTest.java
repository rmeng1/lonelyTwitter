package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by rmeng1 on 10/11/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        try {
            tweets.addTweet(tweet);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testDelete() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet t1 = new NormalTweet("newest", new Date(2017,10,28));
        Tweet t2 = new NormalTweet("2nd oldest", new Date(2017,10,27));
        Tweet t3 = new NormalTweet("3rd oldest", new Date(2017,10,26));
        list.add(t3);
        list.add(t2);
        list.add(t1);

        ArrayList<Tweet> test = list.getTweets();
        if (test.get(0).getDate().compareTo(test.get(1).getDate())>0) {
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
        if (test.get(1).getDate().compareTo(test.get(2).getDate())>0) {
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        int count = list.getCount();
        assertEquals(count, 1);
    }
}
