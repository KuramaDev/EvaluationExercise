package com.example.evaluationexercise.UI.Questions;

import com.example.evaluationexercise.UI.Base.BaseView;

interface QuestionsView extends BaseView {
    void CloseQuestions();
    void ShowGreetings();
    void ShowError(Throwable e);
}
