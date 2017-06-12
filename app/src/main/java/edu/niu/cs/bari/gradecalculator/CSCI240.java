package edu.niu.cs.bari.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class CSCI240 extends AppCompatActivity
    {
    //create the java variables for the widgets used
    EditText Quiz1, Quiz2, Quiz3, Quiz4, Quiz5, Quiz6, Quiz7, Quiz8, Quiz9, Quiz10, Quiz11, Quiz12,
             Exam1, Exam2, Exam3,
             Assgn1, Assgn2, Assgn3, Assgn4, Assgn5, Assgn6, Assgn7, Assgn8, Assgn9, Assgn10;
    Button result240Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csci240);

        //connect all the Quizzes text fields
        Quiz1 = (EditText)findViewById(R.id.Q1);
        Quiz2 = (EditText)findViewById(R.id.Q2);
        Quiz3 = (EditText)findViewById(R.id.Q3);
        Quiz4 = (EditText)findViewById(R.id.Q4);
        Quiz5 = (EditText)findViewById(R.id.Q5);
        Quiz6 = (EditText)findViewById(R.id.Q6);
        Quiz7 = (EditText)findViewById(R.id.Q7);
        Quiz8 = (EditText)findViewById(R.id.Q8);
        Quiz9 = (EditText)findViewById(R.id.Q9);
        Quiz10 = (EditText)findViewById(R.id.Q10);
        Quiz11 = (EditText)findViewById(R.id.Q11);
        Quiz12 = (EditText)findViewById(R.id.Q12);

        //connect all the exams text fields
        Exam1 = (EditText)findViewById(R.id.E1);
        Exam2 = (EditText)findViewById(R.id.E2);
        Exam3 = (EditText)findViewById(R.id.E3);

        //connect all the assignment's text fields
        Assgn1 = (EditText)findViewById(R.id.A1);
        Assgn2 = (EditText)findViewById(R.id.A2);
        Assgn3 = (EditText)findViewById(R.id.A3);
        Assgn4 = (EditText)findViewById(R.id.A4);
        Assgn5 = (EditText)findViewById(R.id.A5);
        Assgn6 = (EditText)findViewById(R.id.A6);
        Assgn7 = (EditText)findViewById(R.id.A7);
        Assgn8 = (EditText)findViewById(R.id.A8);
        Assgn9 = (EditText)findViewById(R.id.A9);
        Assgn10 = (EditText)findViewById(R.id.A10);

        //connect the results button
        result240Btn = (Button)findViewById(R.id.button240Back);

        //setting the onclickListener for going back to MainActivity and getting the grade
        result240Btn.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                //declare all the necessary variables to get the points for assignments, quizzes and exams
                Integer q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12,
                        e1, e2, e3,
                        a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                        quizTotal = 0, examTotal = 0, assignTotal = 0, testAverage;

                Double testAveragetemp, assignTotaltemp, totalPointstemp;

                //if condition for empty quiz fields
                if(Quiz1.getText().toString().matches("") || Quiz2.getText().toString().matches("") ||
                        Quiz3.getText().toString().matches("") || Quiz4.getText().toString().matches("") ||
                        Quiz5.getText().toString().matches("") || Quiz6.getText().toString().matches("") ||
                        Quiz7.getText().toString().matches("") || Quiz8.getText().toString().matches("") ||
                        Quiz9.getText().toString().matches("") || Quiz10.getText().toString().matches("") ||
                        Quiz11.getText().toString().matches("") || Quiz12.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing a Quiz field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for quiz empty fields

                //if condition for empty exam fields
                if(Exam1.getText().toString().matches("") || Exam2.getText().toString().matches("") ||
                        Exam3.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing an Exam field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for exam empty fields

                //if condition for empty assignment fields
                if(Assgn1.getText().toString().matches("") || Assgn2.getText().toString().matches("") ||
                        Assgn3.getText().toString().matches("") || Assgn4.getText().toString().matches("") ||
                        Assgn5.getText().toString().matches("") || Assgn6.getText().toString().matches("") ||
                        Assgn7.getText().toString().matches("") || Assgn8.getText().toString().matches("") ||
                        Assgn9.getText().toString().matches("") || Assgn10.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing an Assignment field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for assignment empty fields

                //get all the integer values from quizzes
                q1 = Integer.parseInt(Quiz1.getText().toString());
                q2 = Integer.parseInt(Quiz2.getText().toString());
                q3 = Integer.parseInt(Quiz3.getText().toString());
                q4 = Integer.parseInt(Quiz4.getText().toString());
                q5 = Integer.parseInt(Quiz5.getText().toString());
                q6 = Integer.parseInt(Quiz6.getText().toString());
                q7 = Integer.parseInt(Quiz7.getText().toString());
                q8 = Integer.parseInt(Quiz8.getText().toString());
                q9 = Integer.parseInt(Quiz9.getText().toString());
                q10 = Integer.parseInt(Quiz10.getText().toString());
                q11 = Integer.parseInt(Quiz11.getText().toString());
                q12 = Integer.parseInt(Quiz12.getText().toString());

                //if condition to check if the quiz fields are less than or equal to 10
                if(q1 > 10 || q2 > 10 || q3 > 10 || q4 > 10 || q5 > 10 || q6 > 10 || q7 > 10 || q8 > 10 || q9 > 10 ||
                        q10 > 10 || q11 > 10 || q12 > 10)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Quiz points cannot be more than \"10\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for quiz fields

                //get all the integer values from exams
                e1 = Integer.parseInt(Exam1.getText().toString());
                e2 = Integer.parseInt(Exam2.getText().toString());
                e3 = Integer.parseInt(Exam3.getText().toString());

                //if condition to check if the exam fields are less than or equal to 100
                if(e1 > 100 || e2 > 100 || e3 > 100)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Exam points cannot be more than \"100\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for exam fields

                //get all the integer values from assignments
                a1 = Integer.parseInt(Assgn1.getText().toString());//100
                a2 = Integer.parseInt(Assgn2.getText().toString());
                a3 = Integer.parseInt(Assgn3.getText().toString());
                a4 = Integer.parseInt(Assgn4.getText().toString());
                a5 = Integer.parseInt(Assgn5.getText().toString());
                a6 = Integer.parseInt(Assgn6.getText().toString());
                a7 = Integer.parseInt(Assgn7.getText().toString());
                a8 = Integer.parseInt(Assgn8.getText().toString());
                a9 = Integer.parseInt(Assgn9.getText().toString());
                a10 = Integer.parseInt(Assgn10.getText().toString());

                //if condition to check if the assignment fields are less than 100
                if(a1 > 100 || a2 > 100 || a3 > 100 || a4 > 100 || a5 > 100 || a6 > 100 || a7 > 100 || a8 > 100 || a9 > 100 ||
                        a10 > 100)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Assignment points cannot be more than \"100\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for assignment fields

                //create an array list to store the quiz points
                List<Integer> quizList;
                quizList = new ArrayList<Integer>();

                //add all the quiz points one by one into the array list
                quizList.add(q1);
                quizList.add(q2);
                quizList.add(q3);
                quizList.add(q4);
                quizList.add(q5);
                quizList.add(q6);
                quizList.add(q7);
                quizList.add(q8);
                quizList.add(q9);
                quizList.add(q10);
                quizList.add(q11);
                quizList.add(q12);

                //to call the sort function, we have to make use of collections. This will sort the array list in ascending order
                //of the numbers added into the list.
                Collections.sort(quizList);

                //as per the requirement, the two lowest scores should be removed and so we make use of the remove function, giving
                //an index of 0, since it is arranged in ascending order.
                quizList.remove(0);
                quizList.remove(0);

                //this for loop is required to add the array list items
                for(Integer integer: quizList)
                    quizTotal += integer;

                //calculate the sum of your exams
                examTotal = e1 + e2 + e3;

                //testAverage is the sum of the quiz points(minus the two lowest scores) and the exam points.
                testAverage = quizTotal + examTotal;

                //the total of quiz and exam will count for 70% of the grade
                testAveragetemp = (Double)(testAverage * 0.7);

                //calcualte the sum of assignment points
                assignTotal = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10;

                //calculate 30% of the assignmen points
                assignTotaltemp = (Double)(assignTotal * 0.3);

                //find the total of the student
                totalPointstemp = (((testAveragetemp + assignTotaltemp) / 580) * 100);

                //create an intent to send back the results
                Intent intent;
                intent = getIntent();

                //put in the grade to pass it to the MainActivity
                intent.putExtra("check", totalPointstemp);

                //set the result and pass the intent
                ((Activity)v.getContext()).setResult(RESULT_OK, intent);

                //finish() calls the MainActivity
                finish();
                }//end of onClick
            });//end of onClick
        }//end of onCreate
    }//end of CSCI240
