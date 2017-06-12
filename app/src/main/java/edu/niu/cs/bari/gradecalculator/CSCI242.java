package edu.niu.cs.bari.gradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CSCI242 extends AppCompatActivity
    {
    public EditText quiz,assignment;
    String BASE_URL = "https://grades-backend.herokuapp.com";
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csci242);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onLogin(View v){

    RestAdapter adapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL) //Setting the Root URL
            .build();

    AppConfig.database api = adapter.create(AppConfig.database.class);
    quiz= (EditText)findViewById(R.id.quiz);
    assignment= (EditText)findViewById(R.id.assignment);
    String value_quiz = quiz.getText().toString();
    int finalvalue_quiz = Integer.parseInt(value_quiz);
    String value_assignment = quiz.getText().toString();
    int finalvalue_assignment = Integer.parseInt(value_assignment);
    Log.d("quiz", String.valueOf(finalvalue_quiz));
    Log.d("assignment", String.valueOf(finalvalue_assignment));
    api.grades(
            finalvalue_quiz,
            finalvalue_assignment,
            new Callback<Response>() {
            @Override
            public void success(Response result, Response response) {

            try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
            String resp;
            resp = reader.readLine();
            Log.d("success", "" + resp);

            JSONObject jObj = new JSONObject(resp);
            int success = jObj.getInt("success");

            if(success == 1){
            Toast.makeText(getApplicationContext(), "Inserted Successful", Toast.LENGTH_SHORT).show();

            } else{
            Toast.makeText(getApplicationContext(), "Insertion Fail", Toast.LENGTH_SHORT).show();
            }


            } catch (IOException e) {
            Log.d("Exception", e.toString());
            } catch (JSONException e) {
            Log.d("JsonException", e.toString());
            }
            }

            @Override
            public void failure(RetrofitError error) {
            Toast.makeText(CSCI242.this, error.toString(), Toast.LENGTH_LONG).show();
            }
            }
    );

    }


}
