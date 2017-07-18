package com.vulpineinteractive.mathhead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity
{

    //class vars
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
        mQuestionTextField.setText("10");
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mAnswerGroup = (RadioGroup) findViewById(R.id.answerGroup);

        //setup listeners
        mSubmitButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                //get selected radio text
                if(mAnswerGroup.getCheckedRadioButtonId() != -1) {

                    RadioButton selectedButton = (RadioButton) findViewById(mAnswerGroup.getCheckedRadioButtonId());
                    CharSequence activeText = selectedButton.getText();

                    //show value with toast
                    Toast toast = Toast.makeText(getApplicationContext(), activeText, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }
                else
                {
                    //show value with toast
                    Toast toast = Toast.makeText(getApplicationContext(), "Select an answer", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }

            }
        });
    }
}
