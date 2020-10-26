package com.example.evaluationexercise.UI.Base;

public interface BasePresenter<V extends BaseView>{
    void onAttach(V view);
    void onDetach();
}
