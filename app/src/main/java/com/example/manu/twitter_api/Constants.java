package com.example.manu.twitter_api;

/**
 * Created by Manu on 9/22/2015.
 */
public class Constants {
    public static final String CONSUMER_KEY = "WlRDpn5VeGJuNZ6bojzbymVJD";
    public static final String CONSUMER_SECRET= "BVxiuLZDZ1GSeRTxKkghtp9zG86AB3cQCuxIfuZ271IvHyYRpo";

    public static final String REQUEST_URL = "http://api.twitter.com/oauth/request_token";
    public static final String ACCESS_URL = "http://api.twitter.com/oauth/access_token";
    public static final String AUTHORIZE_URL = "http://api.twitter.com/oauth/authorize";

    final public static String  CALLBACK_SCHEME = "x-latify-oauth-twitter";
    final public static String  CALLBACK_URL = CALLBACK_SCHEME + "://callback";

}
