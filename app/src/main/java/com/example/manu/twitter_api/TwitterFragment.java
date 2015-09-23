package com.example.manu.twitter_api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

/**
 * Created by Manu on 9/22/2015.
 */
public class TwitterFragment extends Fragment {
    CommonsHttpOAuthConsumer consumer;
    CommonsHttpOAuthProvider provider;
    final String TAG = "Retrograde";
    @Override
    public void onCreate(Bundle savedInstanceState){
        try {
            this.consumer = new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
            this.provider = new CommonsHttpOAuthProvider(Constants.REQUEST_URL, Constants.ACCESS_URL, Constants.AUTHORIZE_URL);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }

        Log.d(TAG, "Starting task to retrieve request token");
        new OAuthRequestTokenTask(this.getContext(),consumer,provider).execute();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    public class OAuthRequestTokenTask extends AsyncTask<Void,Void,Void>{
        private Context context;
        private OAuthProvider provider;
        private OAuthConsumer consumer;
        public OAuthRequestTokenTask(Context context, OAuthConsumer consumer, OAuthProvider provder){
            this.context = context;
            this.consumer = consumer;
            this.provider = provider;
        }
        @Override
        protected Void doInBackground(Void... params) {
            try {
                final String url = provider.retrieveRequestToken(consumer, Constants.CALLBACK_URL);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_FROM_BACKGROUND);
                context.startActivity(intent);
            }catch (Exception e) {
                Log.d(TAG,e.toString());
            }
            return null;
            }

    }
}
