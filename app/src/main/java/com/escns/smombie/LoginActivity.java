package com.escns.smombie;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.escns.smombie.DAO.Record;
import com.escns.smombie.DAO.User;
import com.escns.smombie.DAO.UserJoinRecord;
import com.escns.smombie.Interface.ApiService;
import com.escns.smombie.Manager.DBManager;
//import com.facebook.AccessToken;
//import com.facebook.CallbackManager;
//import com.facebook.FacebookCallback;
//import com.facebook.FacebookException;
//import com.facebook.FacebookSdk;
//import com.facebook.GraphRequest;
//import com.facebook.GraphResponse;
//import com.facebook.login.LoginResult;
//import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hyo99 on 2016-08-10.
 */

public class LoginActivity extends Activity {

    private DBManager mDbManager;
    private SharedPreferences pref;

    private String mUserId;
    private String mUserPassword;
    private String mUserName;
    private int mUserAge;
    private String mUserGender;
    private String mUserEmail;
    private int mUserPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);

        if(pref.getBoolean("isFirst",true)) {

            SharedPreferences.Editor edit = pref.edit();
            edit.putBoolean("isFirst", false);
            edit.commit();

            mDbManager = new DBManager(this);
            //mDbManager.dropAllTable();
            mDbManager.CreateAllTable();

            Record r = new Record(100, "적립", 2016, 12, 7, 1);
            mDbManager.insertRecord(r);
            r = new Record(200, "소비", 2016, 12, 7, 3);
            mDbManager.insertRecord(r);
            r = new Record(520, "적립", 2016, 12, 7, 4);
            mDbManager.insertRecord(r);
            r = new Record(30, "적립", 2016, 12, 8, 0);
            mDbManager.insertRecord(r);

            mUserId = "abc123";
            mUserPassword = "123";
            mUserName = "김병우";
            mUserAge = 25;
            mUserGender = "남자";
            mUserEmail = "hyo99075@naver.com";
            mUserPoint = 450;

            SharedPreferences.Editor editor = pref.edit();
            editor.putString("userId", mUserId);
            editor.putString("userPassword", mUserPassword);
            editor.putString("userName", mUserName);
            editor.putInt("userAge", mUserAge);
            editor.putString("userGender", mUserGender);
            editor.putString("userEmail", mUserEmail);
            editor.putInt("userPoint", mUserPoint);
            editor.commit();
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
