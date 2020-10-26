package com.example.evaluationexercise.UI.Main;


import com.example.evaluationexercise.UI.Base.BasePresenter;


interface MainPresenter<V extends MainActivityView> extends BasePresenter<V> {
   void FetchBranches();
}
