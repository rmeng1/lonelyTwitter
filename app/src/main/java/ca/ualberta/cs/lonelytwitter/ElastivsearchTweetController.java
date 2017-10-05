/*
 * Copyright 2017 Team X, CMPUT 301 , University of Alberta- All Rights Reserved.
 *  You may use distribute , or modify this code under terns and conditions of the Code of Student Behavior at University of Alberta.
 *   You can find the copy of the license in this project, Otherwise please contact contact@abc.ca.
 */

package ca.ualberta.cs.lonelytwitter;
import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;


import static android.R.id.message;

/**
 * Created by rmeng1 on 10/4/17.
 */

public class ElastivsearchTweetController {
    private static JestDroidClient client;

    // TODO we need a function which adds tweets to elastic search
    public static class AddTweetsTask extends AsyncTask<NormalTweet, Void, Void> {

        @Override
        protected Void doInBackground(NormalTweet... tweets) {
            verifySettings();

            for (NormalTweet tweet : tweets) {
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()){
                        tweet.setId(result.getId());
                    }
                    else {
                        Log.i("Error","Elasticsearch was not able to add the tweet");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweet ");
                }

            }
            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... search_parameters) {
            verifySettings();


            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();


            // TODO Build the query

            String query = "{"query" : {"term" : {"message": %s }}}";
            String result = String.format(query,search_parameters);
            Search search = new Search.Builder(result).addIndex("testing").addType("tweet").build();


            /*
            * Search search = new Search.Builder(search_paramerers[0])
            * .addIndex("testint")
            * .addType("tweet")
            * .bulid();
            * */

            try {
                // TODO get the results of the query

                SearchResult result = client.execute(search);
                if (result.isSucceeded()){
                    List<NormalTweet> foundTweets = result.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(foundTweets);
                }
                else {
                    Log.i("Error","The search query failed to find any tweets that matched");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }






    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}
