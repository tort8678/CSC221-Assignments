package com.example.assignment4;

public class Question {
    private int mTextResId;

    private int mCorrectAnswer;

    private int answers[];




    public Question(int textResId, int correctAnswer, int a[]){
        mTextResId = textResId;
        mCorrectAnswer = correctAnswer;
        answers = a;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public int getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public int getChoice(int index){
        try{
            return answers[index];
        } catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }



    public void setTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public void setCorrectAnswer(int correctAnswer) {
        mCorrectAnswer = correctAnswer;
    }
}
