package com.vulpineinteractive.mathhead.dataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Geoff "Kit Foxboy" Lambert on 7/18/17.
 */

public class QuestionBank
{
    //class properties
    public int getLeftTerm() {
        return mLeftTerm;
    }

    public int getRightTerm() {
        return mRightTerm;
    }

    public int getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public int[] getAnswers()
    {
        //define answers
        int[] answers = {mCorrectAnswer, mWrongAnswers[0], mWrongAnswers[1], mWrongAnswers[2]};
        List<Integer> answersAsList = new ArrayList<Integer>();

        //shuffle as a list
        intToList(answers, answersAsList);
        Collections.shuffle(answersAsList);
        listToInt(answers, answersAsList);

        return answers;
    }


    //class vars
    private int mLeftTerm = 0;
    private int mRightTerm = 0;
    private int mCorrectAnswer = 0;
    private int[] mWrongAnswers = new int[3];
    private Random random = new Random();


    //class methods
    public void generateQuestion()
    {
        //generate random terms
        mLeftTerm = random.nextInt(100) + 1;
        mRightTerm = random.nextInt(100) + 1;

        //calculate correct answer
        mCorrectAnswer = mLeftTerm + mRightTerm;

        //calculate wrong answers
        for(int i = 1; i <= mWrongAnswers.length; i++)
        {
            mWrongAnswers[i-1] = (i % 2 == 0) ? mCorrectAnswer + i : mCorrectAnswer - i;
        }
    }

    private void intToList(int[] answerArr, List<Integer> answerList)
    {
        for(int answer : answerArr)
        {
            answerList.add(Integer.valueOf(answer));
        }
    }

    private void listToInt(int[] answerArr, List<Integer> answerList)
    {
        for(int i = 0; i < answerList.size(); i++)
        {
            answerArr[i] = answerList.get(i);
        }
    }
}
