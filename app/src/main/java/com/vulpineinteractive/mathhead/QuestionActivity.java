package com.vulpineinteractive.mathhead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vulpineinteractive.mathhead.dataModel.QuestionBank;

public class QuestionActivity extends AppCompatActivity
{

    //class vars
    private QuestionBank mQuestionBank = new QuestionBank();
    private TextView mQuestionTextField;
    private Button mSubmitButton;
    private RadioGroup mAnswerGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //call parent
        super.onCreate(savedInstanceState);

        //assign content view
        setContentView(R.layout.activity_question);

        //initialize views
        mQuestionTextField = (TextView) findViewById(R.id.questionTextField);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mAnswerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        populate();

        //setup listeners
        mSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setup toast
                Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 50);

                //get selected radio text
                if(mAnswerGroup.getCheckedRadioButtonId() != -1) {

                    //get selected answer
                    RadioButton selectedButton = (RadioButton) findViewById(mAnswerGroup.getCheckedRadioButtonId());
                    String buttonText = selectedButton.getText().toString();
                    int answer = Integer.parseInt(buttonText);

                    //show result
                    if(answer == mQuestionBank.getCorrectAnswer())
                    {
                        //show result
                        toast.setText("Correct!");

                        //pause briefly
                        populate();
                    }
                    else
                    {
                        //show result
                        toast.setText("Bummer! Try again");
                    }
                }
                else
                {
                    //show value with toast
                    toast.setText("Select an answer");
                    toast.setGravity(Gravity.TOP, 0, 0);
                }

                //show toast
                toast.show();

            }
        });
    }

    public void populate()
    {
        //setup new question
        mQuestionBank.generateQuestion();
        int[] answers = mQuestionBank.getAnswers();

        //display answers
        int answerCount = 0;
        for(int i = 0; i < mAnswerGroup.getChildCount(); i++)
        {
            //update radio button children
            View obj = mAnswerGroup.getChildAt(i);
            if(obj instanceof RadioButton)
            {
                RadioButton button = (RadioButton) obj;
                button.setChecked(false);
                button.setText(String.valueOf(answers[answerCount]));

                answerCount++;
            }
        }

        //display question
        mQuestionTextField.setText(mQuestionBank.getLeftTerm() + " + " + mQuestionBank.getRightTerm());
    }
}
