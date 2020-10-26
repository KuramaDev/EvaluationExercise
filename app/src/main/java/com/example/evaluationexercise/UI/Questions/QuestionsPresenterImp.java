package com.example.evaluationexercise.UI.Questions;

import android.app.Application;
import android.util.Log;
import com.example.evaluationexercise.Models.AnswerBody;
import com.example.evaluationexercise.Models.SubmitResponse;
import com.example.evaluationexercise.Services.Network.APIClient;
import com.example.evaluationexercise.Services.Network.APIService;
import com.example.evaluationexercise.UI.Base.BasePresenterImp;
import java.util.HashMap;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

class QuestionsPresenterImp<V extends QuestionsView> extends BasePresenterImp<V > implements QuestionsPresenter<V> {

    public static final  String TAG = Application.class.getSimpleName();

    private AnswerBody answerBody;
    private HashMap<String,Integer> happinessAnswers;
    private HashMap<String,Integer> secondAnswers;

    public QuestionsPresenterImp(){
        answerBody = new AnswerBody();
        happinessAnswers = new HashMap<>();
        secondAnswers = new HashMap<>();
        InitHappinessAnswers();
        InitSecondAnswers();
    }

    @Override
    public void PrepareAnswerToPost(int answer1, int answer2) {
        SetHappinessAnswers(answer1);
        SetSecondQuestionAnswers(answer2);
        Log.d(TAG , answerBody.toString());
        PostAnswerToServer();
    }

    @Override
    public void SetBranchId(String branchId) {
        answerBody.setBranchId(branchId);
    }

    private void SetHappinessAnswers(int happinessMeter){
        switch (happinessMeter){
            case 0 :
                happinessAnswers.put("Bad",1);
                break;
            case 1:
                happinessAnswers.put("NotHappy",1);
                break;
            case 2:
                happinessAnswers.put("Happy",1);
                break;
            case 3:
                happinessAnswers.put("Vhappy" , 1);
                break;
        }
        answerBody.setBad(happinessAnswers.get("Bad"));
        answerBody.setNotHappy(happinessAnswers.get("NotHappy"));
        answerBody.setHappy(happinessAnswers.get("Happy"));
        answerBody.setVhappy(happinessAnswers.get("Vhappy"));
    }

    private void SetSecondQuestionAnswers(int answer2){
        switch (answer2-1){
            case 0 :
                secondAnswers.put("An1",1);
                break;
            case 1:
                secondAnswers.put("An2",1);
                break;
            case 2:
                secondAnswers.put("An3",1);
                break;
            case 3:
                secondAnswers.put("An4",1);
                break;
        }
        answerBody.setAn1(secondAnswers.get("An1"));
        answerBody.setAn2(secondAnswers.get("An2"));
        answerBody.setAn3(secondAnswers.get("An3"));
        answerBody.setAn4(secondAnswers.get("An4"));
        answerBody.setAn5(0);
    }

    private void InitHappinessAnswers(){
        happinessAnswers.put("Bad", 0);
        happinessAnswers.put("NotHappy", 0);
        happinessAnswers.put("Happy",0);
        happinessAnswers.put("Vhappy",0);
    }

    private void InitSecondAnswers(){
        secondAnswers.put("An1",0);
        secondAnswers.put("An2",0);
        secondAnswers.put("An3",0);
        secondAnswers.put("An4",0);
        secondAnswers.put("An5",0);
    }

    private void PostAnswerToServer(){
        APIService apiservice = APIClient.getClient().create(APIService.class);
        apiservice.SubmitAnswer(answerBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<SubmitResponse>(){
                    @Override
                    public void onSuccess(SubmitResponse submitResponse){
                        Log.d(TAG, submitResponse.toString());
                        getView().ShowGreetings();
                        getView().CloseQuestions();
                    }

                    @Override
                    public void onError(Throwable e){
                        Log.d(TAG,"FETCHED ERROR");
                        getView().ShowError(e);
                    }
                });
    }

}
