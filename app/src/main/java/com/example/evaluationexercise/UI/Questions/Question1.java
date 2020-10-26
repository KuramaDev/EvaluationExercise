package com.example.evaluationexercise.UI.Questions;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.evaluationexercise.R;
import com.example.evaluationexercise.UI.Base.BaseActivity;
import com.example.evaluationexercise.UI.Base.BaseFragment;


public class Question1 extends BaseFragment implements SeekBar.OnSeekBarChangeListener , View.OnClickListener {

    SeekBar answerBar ;
    CircleImageView happinessImage;
    TextView happinessMessage ;
    Button next;
    FragmentEventListener callback;

    public Question1() {

    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof QuestionsActivity){
            this.callback = (FragmentEventListener) context;
        }
    }

    public static Question1 newInstance() {
        Question1 fragment = new Question1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question1, container, false);
    }


    @Override
    public void setUp(View view){
        answerBar = view.findViewById(R.id.happinessBar);
        answerBar.setOnSeekBarChangeListener(this);
        happinessImage = view.findViewById(R.id.happinessImage);
        happinessMessage = view.findViewById(R.id.happinessMessage);
        next = view.findViewById(R.id.button);
        next.setOnClickListener(this);
    }

    @Override
    public void ShowLoading(){

    }

    @Override
    public void HideLoading(){

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("SeekBar to: " , "" + i);
        switch(i){
            case 0:
                happinessImage.setImageResource(R.drawable.badd);
                happinessMessage.setText(R.string.badService);
                break;
            case 1:
                happinessImage.setImageResource(R.drawable.almostbadd);
                happinessMessage.setText(R.string.lowService);
                break;
            case 2:
                happinessImage.setImageResource(R.drawable.notsohappy);
                happinessMessage.setText(R.string.highService);
                break;
            case 3:
                happinessImage.setImageResource(R.drawable.happycustome);
                happinessMessage.setText(R.string.perfectService);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        callback.UpdateAnswerResult(seekBar.getProgress());
    }

    @Override
    public void onClick(View view) {
              callback.ReplaceFragment();
    }
}