package com.example.evaluationexercise.UI.Base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.example.evaluationexercise.Utils.Utils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseView, BaseFragment.Callback {

    public static boolean isNetworkConnected = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void ShowLoading() {

        Utils.getInstance().showLoadingDialog(this);
    }

    @Override
    public void HideLoading() {
        Utils.getInstance().HideLoadingDialog();
    }

    protected abstract void setUp();

    @Override
    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    public void onFragmentAttached(){

    }

    @Override
    public  void onFragmentDetached(){

    }
}
