package edu.niu.cs.bari.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    {
    //create the java variables for the widgets used
    Button btn240, btn241;
    TextView resultTV;
    public final int REQUEST_CODE = 240;
    public final int REQUEST_CODE1 = 241;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the java variable with the results text field
        resultTV = (TextView)findViewById(R.id.resultTextView);

        //connect the button for 240
        btn240 = (Button)findViewById(R.id.button240);

        //connect the button for 241
        btn241 = (Button)findViewById(R.id.button241);

        //setting the onClickListener for 240
        btn240.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View v)
        {
        //create an intent to call the 240 xml file
        Intent intent = new Intent(MainActivity.this, CSCI240.class);
        intent.putExtra("check", true);

        //start the activity for 240
        startActivityForResult(intent, REQUEST_CODE);
        }//end of onClick
        });//end of setOnClickListener

        //setting the onClickListener for 241
        btn241.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                //create an intent to call the 241 xml file
                Intent intent = new Intent(MainActivity.this, CSCI241.class);
                intent.putExtra("check", true);

                //start the activity for 241
                startActivityForResult(intent, REQUEST_CODE1);
                }//end of onClick
            });//end of setOnCLickListener
        }//end of onCreate


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
        //returnedValue will store the grade
        Double returnedValue;

        //this if condition is for 240
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
            {
                returnedValue = data.getDoubleExtra("check", 0);

            //these are the grading scales for various grades
                if (returnedValue >= 90)
                    resultTV.setText("CSCI 240 - \"A\" grade.");

                else if (returnedValue >= 80 && returnedValue <= 89.99)
                    resultTV.setText("CSCI 240 - \"B\" grade.");

                else if (returnedValue >= 70 && returnedValue <= 79.99)
                    resultTV.setText("CSCI 240 - \"C\" grade.");

                else if (returnedValue >= 60 && returnedValue <= 69.99)
                    resultTV.setText("CSCI 240 - \"D\" grade.");

                else if (returnedValue >= 0 && returnedValue <= 59.99)
                    resultTV.setText("CSCI 240 - \"F\" grade.");
            }//end of if for 240

            //this else if condition is for 241
        else if(requestCode == REQUEST_CODE1 && resultCode == RESULT_OK)
            {
            returnedValue = data.getDoubleExtra("check", 0);

            //these are the grading scales for various grades
            if (returnedValue >= 90)
                resultTV.setText("CSCI 241 - \"A\" grade.");

            else if (returnedValue >= 80 && returnedValue <= 89.99)
                resultTV.setText("CSCI 241 - \"B\" grade.");

            else if (returnedValue >= 70 && returnedValue <= 79.99)
                resultTV.setText("CSCI 241 - \"C\" grade.");

            else if (returnedValue >= 60 && returnedValue <= 69.99)
                resultTV.setText("CSCI 241 - \"D\" grade.");

            else if (returnedValue >= 0 && returnedValue <= 59.99)
                resultTV.setText("CSCI 241 - \"F\" grade.");
            }//end of if for 241
        }//end of onActivityResult

    public void CSCI242(View view)
        {
        Intent intent = new Intent(MainActivity.this, CSCI242.class);
        startActivity(intent);
        }
    }//end of MainActivity
