package com.example.assignment4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //four answer buttons
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;
    // create a question bank with all six questions, their choices, and their answers
    final private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question1, 3, new int []{
                    R.string.answer1a,
                    R.string.answer1b,
                    R.string.answer1c,
                    R.string.answer1d
            }),
            new Question(R.string.question2, 2, new int []{
                    R.string.answer2a,
                    R.string.answer2b,
                    R.string.answer2c,
                    R.string.answer2d

            }),
            new Question(R.string.question3, 0, new int []{
                    R.string.answer3a,
                    R.string.answer3b,
                    R.string.answer3c,
                    R.string.answer3d

            }),
            new Question(R.string.question4, 2, new int []{
                    R.string.answer4a,
                    R.string.answer4b,
                    R.string.answer4c,
                    R.string.answer4d

            }),
            new Question(R.string.question5, 2, new int []{
                    R.string.answer5a,
                    R.string.answer5b,
                    R.string.answer5c,
                    R.string.answer5d

            }),
            new Question(R.string.question6, 1, new int []{
                    R.string.answer6a,
                    R.string.answer6b,
                    R.string.answer6c,
                    R.string.answer6d

            }),
    };
    // keep track of the question bank index
    private int mCurrentIndex=0;
    // num of correct answers from user
    private int numCorrect = 0;
    // to change question text
    private TextView mQuestionTextView;

    private void checkAnswer(int choice, View view){
        if(choice == mQuestionBank[mCurrentIndex].getCorrectAnswer()){
            Snackbar.make(view,R.string.correct,Snackbar.LENGTH_SHORT).show();
            numCorrect++;
        }
        else Snackbar.make(view,R.string.incorrect,Snackbar.LENGTH_SHORT).show();
        if(mCurrentIndex+1 != mQuestionBank.length) {
            mCurrentIndex++;
            int question = mQuestionBank[mCurrentIndex].getTextResId();
            mQuestionTextView.setText(question);
            mAnswer1.setText(mQuestionBank[mCurrentIndex].getChoice(0));
            mAnswer2.setText(mQuestionBank[mCurrentIndex].getChoice(1));
            mAnswer3.setText(mQuestionBank[mCurrentIndex].getChoice(2));
            mAnswer4.setText(mQuestionBank[mCurrentIndex].getChoice(3));
        }
        else{
            mQuestionTextView.setText("Your Score: "+ numCorrect + " out of "+mQuestionBank.length);
            mAnswer1.setVisibility(View.INVISIBLE);
            mAnswer2.setVisibility(View.INVISIBLE);
            mAnswer3.setVisibility(View.INVISIBLE);
            mAnswer4.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextView= (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);



        //get references to the True and False buttons
        mAnswer1 = findViewById(R.id.answer1);
        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(0,view);
            }
        });

        mAnswer2 = findViewById(R.id.answer2);
        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(1,view);

            }
        });


        mAnswer3 = findViewById(R.id.answer3);
        mAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(2,view);
            }
        });

        mAnswer4 = findViewById(R.id.answer4);
        mAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(3,view);
            }
        });


    }
}
