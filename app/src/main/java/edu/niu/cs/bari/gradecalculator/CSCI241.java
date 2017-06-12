package edu.niu.cs.bari.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSCI241 extends AppCompatActivity
    {
    //create the java variables for the widgets used
    EditText Quiz20, Quiz21, Quiz22, Quiz23, Quiz24, Quiz25, Quiz26, Quiz27, Quiz28, Quiz29, Quiz30, Quiz31,
             Exam20, Exam21, Exam22,
             Assign20, Assign21, Assign22, Assign23, Assign24, Assign25, Assign26, Assign27;
    Button result241Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csci241);

        //connect all the Quizzes text fields
        Quiz20 = (EditText)findViewById(R.id.Q20);
        Quiz21 = (EditText)findViewById(R.id.Q21);
        Quiz22 = (EditText)findViewById(R.id.Q22);
        Quiz23 = (EditText)findViewById(R.id.Q23);
        Quiz24 = (EditText)findViewById(R.id.Q24);
        Quiz25 = (EditText)findViewById(R.id.Q25);
        Quiz26 = (EditText)findViewById(R.id.Q26);
        Quiz27 = (EditText)findViewById(R.id.Q27);
        Quiz28 = (EditText)findViewById(R.id.Q28);
        Quiz29 = (EditText)findViewById(R.id.Q29);
        Quiz30 = (EditText)findViewById(R.id.Q30);
        Quiz31 = (EditText)findViewById(R.id.Q31);

        //connect all the exams fields
        Exam20 = (EditText)findViewById(R.id.E20);
        Exam21 = (EditText)findViewById(R.id.E21);
        Exam22 = (EditText)findViewById(R.id.E22);

        //connect all the assignments fields
        Assign20 = (EditText)findViewById(R.id.A20);
        Assign21 = (EditText)findViewById(R.id.A21);
        Assign22 = (EditText)findViewById(R.id.A22);
        Assign23 = (EditText)findViewById(R.id.A23);
        Assign24 = (EditText)findViewById(R.id.A24);
        Assign25 = (EditText)findViewById(R.id.A25);
        Assign26 = (EditText)findViewById(R.id.A26);
        Assign27 = (EditText)findViewById(R.id.A27);

        //connect the results button
        result241Btn = (Button)findViewById(R.id.button241Back);

        //setting the onClickListener for going back to MainActivity and getting the grade
        result241Btn.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
                {
                //declare all the necessary variables to get the points for assignments, quizzes and exams
                Integer qu1, qu2, qu3, qu4, qu5, qu6, qu7, qu8, qu9, qu10, qu11, qu12,
                        ex1, ex2, ex3,
                        as1, as2, as3, as4, as5, as6, as7, as8,
                        quizTotal1 = 0, examTotal1 = 0, assignTotal1 = 0, testAverage1;
                Double testAveragetemp1, assignTotaltemp1, totalPointstemp1;

                //if condition for empty quiz fields
                if(Quiz20.getText().toString().matches("") || Quiz21.getText().toString().matches("") ||
                        Quiz22.getText().toString().matches("") || Quiz23.getText().toString().matches("") ||
                        Quiz24.getText().toString().matches("") || Quiz25.getText().toString().matches("") ||
                        Quiz26.getText().toString().matches("") || Quiz27.getText().toString().matches("") ||
                        Quiz28.getText().toString().matches("") || Quiz29.getText().toString().matches("") ||
                        Quiz30.getText().toString().matches("") || Quiz31.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing a Quiz field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for quiz's empty fields

                //if condition for empty exam fields
                if(Exam20.getText().toString().matches("") || Exam21.getText().toString().matches("") ||
                        Exam22.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing an Exam field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for exam's empty fields

                //if condition for empty assignment fields
                if(Assign20.getText().toString().matches("") || Assign21.getText().toString().matches("") ||
                        Assign22.getText().toString().matches("") || Assign23.getText().toString().matches("") ||
                        Assign24.getText().toString().matches("") || Assign25.getText().toString().matches("") ||
                        Assign26.getText().toString().matches("") || Assign27.getText().toString().matches(""))
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "You are missing an Assignment field(s).", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for assignment's empty fields

                //get all the integer values from from quizzes
                qu1 = Integer.parseInt(Quiz20.getText().toString());
                qu2 = Integer.parseInt(Quiz21.getText().toString());
                qu3 = Integer.parseInt(Quiz22.getText().toString());
                qu4 = Integer.parseInt(Quiz23.getText().toString());
                qu5 = Integer.parseInt(Quiz24.getText().toString());
                qu6 = Integer.parseInt(Quiz25.getText().toString());
                qu7 = Integer.parseInt(Quiz26.getText().toString());
                qu8 = Integer.parseInt(Quiz27.getText().toString());
                qu9 = Integer.parseInt(Quiz28.getText().toString());
                qu10 = Integer.parseInt(Quiz29.getText().toString());
                qu11 = Integer.parseInt(Quiz30.getText().toString());
                qu12 = Integer.parseInt(Quiz31.getText().toString());

                //if condition to check if the quiz fields are less than or equal to 10
                if(qu1 > 10 || qu2 > 10 || qu3 > 10 || qu4 > 10 || qu5 > 10 || qu6 > 10 || qu7 > 10 || qu8 > 10 || qu9 > 10 ||
                        qu10 > 10 || qu11 > 10 || qu12 > 10)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Quiz points cannot be more than \"10\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for quiz fields

                //get all the integer values from exams
                ex1 = Integer.parseInt(Exam20.getText().toString());
                ex2 = Integer.parseInt(Exam21.getText().toString());
                ex3 = Integer.parseInt(Exam22.getText().toString());

                //if condition to check if the exam fields are less than or equal to 100
                if(ex1 > 100 || ex2 > 100 || ex3 > 100)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Exam points cannot be more than \"100\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for exam fields

                //get all the integer values from assignments
                as1 = Integer.parseInt(Assign20.getText().toString());
                as2 = Integer.parseInt(Assign21.getText().toString());
                as3 = Integer.parseInt(Assign22.getText().toString());
                as4 = Integer.parseInt(Assign23.getText().toString());
                as5 = Integer.parseInt(Assign24.getText().toString());
                as6 = Integer.parseInt(Assign25.getText().toString());
                as7 = Integer.parseInt(Assign26.getText().toString());
                as8 = Integer.parseInt(Assign27.getText().toString());

                //if condition to check if the assignment fields are less than 100
                if(as1 > 100 || as2 > 100 || as3 > 100 || as4 > 100 || as5 > 100 || as6 > 100 || as7 > 100 || as8 > 100)
                    {
                    //display an error message
                    Toast.makeText(v.getContext(), "Your Assignment points cannot be more than \"100\".", Toast.LENGTH_SHORT).show();
                    return;
                    }//end of if for assignment fields

                //create an array list to store the quiz points
                List<Integer> quizList1;
                quizList1 = new ArrayList<Integer>();

                //add all the quiz points one by one into the array list
                quizList1.add(qu1);
                quizList1.add(qu2);
                quizList1.add(qu3);
                quizList1.add(qu4);
                quizList1.add(qu5);
                quizList1.add(qu6);
                quizList1.add(qu7);
                quizList1.add(qu8);
                quizList1.add(qu9);
                quizList1.add(qu10);
                quizList1.add(qu11);
                quizList1.add(qu12);

                //to call the sort function, we have to make use of collections. This will sort the array list in ascending order
                //of the numbers added into the list.
                Collections.sort(quizList1);

                //as per the requirement, the two lowest scores should be removed and so we make use of the remove function, giving
                //an index of 0, since it is arranged in ascending order.
                quizList1.remove(0);
                quizList1.remove(0);

                //this for loop is required to add the array list items
                for(Integer integer1: quizList1)
                    quizTotal1 += integer1;

                //calculate the sum of your exams
                examTotal1 = ex1 + ex2 + ex3;

                //testAverage1 is the sum of the quiz points(minus the two lowest scores) and the exam points.
                testAverage1 = quizTotal1 + examTotal1;

                //the total of quiz and exam will count for 60% of the grade
                testAveragetemp1 = (Double)(testAverage1 * 0.6);

                //calcualte the sum of assignment points
                assignTotal1 = as1 + as2 + as3 + as4 + as5 + as6 + as7 + as8;

                //calculate 40% of the assignmen points
                assignTotaltemp1 = (Double)(assignTotal1 * 0.4);

                //find the total of the student
                totalPointstemp1 = (((testAveragetemp1 + assignTotaltemp1) / 560) * 100);

                //create an intent to send back the results
                Intent intent1;
                intent1 = getIntent();

                //put in the grade to pass it to the MainActivity
                intent1.putExtra("check", totalPointstemp1);

                //set the result and pass the intent
                ((Activity)v.getContext()).setResult(RESULT_OK, intent1);

                //finish() calls the MainActivity
                finish();
                }//end of onClick
            });//end of setOnClickListener
        }//end of onCreate
    }//end of CSCI241
