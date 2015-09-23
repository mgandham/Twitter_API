package com.example.manu.twitter_api;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manu.twitter_api.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Manu on 9/21/2015.
 */
public class LoginFragment extends Fragment {
    String URL = "";
    String TAG = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    public String tryLogin(View view){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URL).build();
        Response strResponse = null;

        try {
            strResponse=client.newCall(request).execute();
        } catch (IOException e) {
            Log.d(TAG, e.toString());
        }
        if (strResponse != null) {

            try {
                return strResponse.body().string();
            }catch (IOException e) {
                Log.d(TAG+"62",e.toString());
                return "dummy";
            }

        } else {
            return "dummy";
        }
    }

}
