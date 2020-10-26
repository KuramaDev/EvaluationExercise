package com.example.evaluationexercise.UI.Questions;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.evaluationexercise.R;
import com.example.evaluationexercise.UI.Base.BaseFragment;

public class Question2 extends BaseFragment implements  View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";

    FragmentEventListener callback;
    RadioGroup radioGroup;
    Button sendAnswers;
    View root ;
    TextView questionText;

    private int mParam1;

    public Question2() {

    }

    public static Question2 newInstance(int param1) {
        Question2 fragment = new Question2();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof QuestionsActivity){
            this.callback = (FragmentEventListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_question2, container, false);
        return root;
    }
    @Override
    protected void setUp(View view) {
        radioGroup = view.findViewById(R.id.optionsArea);
        sendAnswers = view.findViewById(R.id.send);
        questionText = view.findViewById(R.id.question2_text);
        sendAnswers.setOnClickListener(this);
        if (mParam1 >=2){
            questionText.setText(R.string.question2_positive_case);
        }
        else{
            questionText.setText(R.string.question2_negative_case);
        }
    }

    @Override
    public void ShowLoading() {

    }

    @Override
    public void HideLoading() {

    }


    @Override
    public void onClick(View view) {
        int answer = -1;
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = root.findViewById(selectedId);
        if(radioButton != null){
            switch (radioButton.getId()){
                case R.id.option1:
                    answer = 1;
                    break;
                case R.id.option2:
                    answer =2 ;
                    break;
                case R.id.option3:
                    answer = 3;
                    break;
                case R.id.option4:
                    answer = 4;
                    break;
            }
            Log.d("Gonna send to Activity", ""+ answer);
            callback.UpdateAnswerResult(answer);
            callback.EndOfQuestions();

        }else{
            answer = -1;
            Toast.makeText(getContext(), "Είναι αναγκαίο να κάνετε μία επιλογή." , Toast.LENGTH_LONG).show();
        }
    }

}