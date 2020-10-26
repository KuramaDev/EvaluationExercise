package com.example.evaluationexercise.UI.Base;

import android.content.Context;

public interface BaseView {
    void ShowLoading();
    void HideLoading();
    boolean isNetworkConnected(Context context);
}
