package com.example.evaluationexercise.UI.Main;

import android.app.Application;
import android.util.Log;
import com.example.evaluationexercise.Models.BranchInfo;
import com.example.evaluationexercise.Services.Network.APIClient;
import com.example.evaluationexercise.Services.Network.APIService;
import com.example.evaluationexercise.UI.Base.BasePresenterImp;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenterImp<V extends MainActivityView> extends BasePresenterImp<V> implements MainPresenter<V> {

    public static final String TAG = Application.class.getSimpleName();

    @Override
    public void FetchBranches(){
        APIService apiservice = APIClient.getClient().create(APIService.class);
        List<BranchInfo> fetchedBranches = new ArrayList<>();
        apiservice.getBranchList(new Object())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<BranchInfo>>(){
                                    @Override
                                    public void onSuccess(List<BranchInfo> branches){
                                        getView().InitiateList(branches);
                                        getView().HideLoading();
                                    }

                                    @Override
                                    public void onError(Throwable e){
                                        Log.e(TAG , "An error occurred:", e);
                                    }
                                });
    }

}
