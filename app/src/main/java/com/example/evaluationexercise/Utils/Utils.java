package com.example.evaluationexercise.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ProgressBar;

import com.example.evaluationexercise.R;
import com.example.evaluationexercise.UI.Base.BaseActivity;

import androidx.appcompat.app.AlertDialog;

public  class Utils {

    AlertDialog dialog;
    static  Utils instance ;

    private   Utils(){

    }

    public static Utils getInstance(){
        if(instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public void showLoadingDialog(BaseActivity context) {
      //TODO: Initialize Progress Bar dynamically
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false);
        dialog  = builder.create();
        dialog.show();
    }

    public  void HideLoadingDialog(){
        dialog.dismiss();
    }

}
