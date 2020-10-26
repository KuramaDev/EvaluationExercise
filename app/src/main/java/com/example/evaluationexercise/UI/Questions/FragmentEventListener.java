package com.example.evaluationexercise.UI.Questions;

import com.example.evaluationexercise.UI.Base.BaseFragment;

interface FragmentEventListener {
    void ReplaceFragment();
    void UpdateAnswerResult(int number);
    void EndOfQuestions();
}
