package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Created by rmeng1 on 10/11/17.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){};

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public void addTweet(Tweet tweet) {
        if (this.hasTweet(tweet))
            throw new IllegalArgumentException("duplicate list!");
        else
            tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }
}
