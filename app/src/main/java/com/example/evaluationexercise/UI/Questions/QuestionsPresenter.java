package com.example.evaluationexercise.UI.Questions;

import com.example.evaluationexercise.UI.Base.BasePresenter;
import com.example.evaluationexercise.UI.Base.BaseView;

interface QuestionsPresenter<V extends QuestionsView> extends BasePresenter<V> {
    void PrepareAnswerToPost(int answer1 , int answer2);
    void SetBranchId(String branchId);
}
