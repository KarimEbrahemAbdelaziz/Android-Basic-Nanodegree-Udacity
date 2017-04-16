package com.example.karim.quizapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.luolc.emojirain.EmojiRainLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.right;

public class MainActivity extends AppCompatActivity {

    /**
     * Number of questions had been answered right.
     */
    int numbersQuestionsAnsweredRight = 0;

    Toast toastSubmit;

    /**
     * BindViews for questions.
     */
    @BindView(R.id.first_question_info)
    TextView questionOneInfo;
    @BindView(R.id.second_question_info)
    TextView questionTwoInfo;
    @BindView(R.id.third_question_info)
    TextView questionThreeInfo;
    @BindView(R.id.fourth_question_info)
    TextView questionFourInfo;
    @BindView(R.id.fifth_question_info)
    TextView questionFiveInfo;
    @BindView(R.id.sixth_question_info)
    TextView questionSixInfo;

    /**
     * BindView for first question answer
     * - Next prime after 7 ?
     */
    @BindView(R.id.question1_answer4)
    RadioButton answerQuestionOne;

    /**
     * BindView for second question answer
     * - 3 squared equal ?
     */
    @BindView(R.id.question2_answer2)
    RadioButton answerQuestionTwo;

    /**
     * BindView for third question answer
     * - How many sides of nonagon ?
     */
    @BindView(R.id.question3_answer3)
    RadioButton answerQuestionThree;

    /**
     * BindView for forth question answer
     * - True or False ? -2 is an integer.
     */
    @BindView(R.id.question4_answer)
    EditText answerQuestionFour;

    /**
     * BindViews for fifth question answers
     * 87 + 56 = ?
     */
    @BindView(R.id.question5_answer1)
    CheckBox answerQuestionFiveTrue1;
    @BindView(R.id.question5_answer2)
    CheckBox answerQuestionFiveFalse1;
    @BindView(R.id.question5_answer3)
    CheckBox answerQuestionFiveFalse2;
    @BindView(R.id.question5_answer4)
    CheckBox answerQuestionFiveTrue2;

    /**
     * BindView for sixth question answer
     * - True or False ? -4 is a natural number.
     */
    @BindView(R.id.question6_answer)
    EditText answerQuestionSix;

    private EmojiRainLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContainer = (EmojiRainLayout) findViewById(R.id.group_emoji_container);

        // add star sources
        mContainer.addEmoji(R.drawable.star);
        // set star per flow
        mContainer.setPer(5);
        // set total duration in milliseconds
        mContainer.setDuration(7200);
        // set average drop duration in milliseconds
        mContainer.setDropDuration(2400);
        // set drop frequency in milliseconds
        mContainer.setDropFrequency(500);
    }

    /**
     * Submit the answers and show the results.
     * @param view
     */
    @OnClick(R.id.submit_answer)
    public void submitAnswer(View view){

        // Reset the number of answered questions to zero
        if(numbersQuestionsAnsweredRight != 0){
            numbersQuestionsAnsweredRight = 0;
        }

        // Review all questions
        questionOneReview();
        questionTwoReview();
        questionThreeReview();
        questionFourReview();
        questionFiveReview();
        questionSixReview();

        if(numbersQuestionsAnsweredRight == 0){
            showToast("You didn't answered any question right.");
        }
        else if(numbersQuestionsAnsweredRight < 6 && numbersQuestionsAnsweredRight > 0) {
            showToast("You answered " + numbersQuestionsAnsweredRight + " questions right !!");
        }
        if(numbersQuestionsAnsweredRight == 6) {
            showToast("Congratulations, You answered all questions right !!");
            mContainer.startDropping();
        }
    }

    /**
     * This function is to handle the toast messages.
     * @param text is the message i wanna show in toast.
     */
    void showToast(String text)
    {
        if(toastSubmit == null)
        {
            toastSubmit = Toast.makeText(this, text, Toast.LENGTH_LONG);
        }

        toastSubmit.setText(text);
        toastSubmit.setDuration(Toast.LENGTH_LONG);
        toastSubmit.show();
    }

    /**
     * Function to check if the first question answered right.
     */
    private void questionOneReview(){
        if(answerQuestionOne.isChecked()){
            // If right answer change question text color to green.
            questionOneInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionOneInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

    /**
     * Function to check if the second question answered right.
     */
    private void questionTwoReview(){
        if(answerQuestionTwo.isChecked()){
            // If right answer change question text color to green.
            questionTwoInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionTwoInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

    /**
     * Function to check if the third question answered right.
     */
    private void questionThreeReview(){
        if(answerQuestionThree.isChecked()){
            // If right answer change question text color to green.
            questionThreeInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionThreeInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

    /**
     * Function to check if the fourth question answered right.
     */
    private void questionFourReview(){
        String trueAnswer = "true";
        String answerEntered = answerQuestionFour.getText().toString();
        answerEntered = answerEntered.toLowerCase();
        if(answerEntered.equals(trueAnswer)){
            // If right answer change question text color to green.
            questionFourInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionFourInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

    /**
     * Function to check if the fifth question answered right.
     */
    private void questionFiveReview(){
        boolean answerRight1 = answerQuestionFiveTrue1.isChecked();
        boolean answerRight2 = answerQuestionFiveTrue2.isChecked();
        boolean answerWrong1 = answerQuestionFiveFalse1.isChecked();
        boolean answerWrong2 = answerQuestionFiveFalse2.isChecked();
        if((answerRight1 && answerRight2) && !(answerWrong1 || answerWrong2)){
            // If right answer change question text color to green.
            questionFiveInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionFiveInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

    /**
     * Function to check if the sixth question answered right.
     */
    private void questionSixReview(){
        String trueAnswer = "false";
        String answerEntered = answerQuestionSix.getText().toString();
        answerEntered = answerEntered.toLowerCase();
        if(answerEntered.equals(trueAnswer)){
            // If right answer change question text color to green.
            questionSixInfo.setTextColor(Color.parseColor("#08ea0c"));
            numbersQuestionsAnsweredRight += 1;
        }else {
            // If wrong answer change question text color to red.
            questionSixInfo.setTextColor(Color.parseColor("#df1c1c"));
        }
    }

}
