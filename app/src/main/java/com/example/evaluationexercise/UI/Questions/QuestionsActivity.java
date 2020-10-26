package com.example.evaluationexercise.UI.Questions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.evaluationexercise.R;
import com.example.evaluationexercise.UI.Base.BaseActivity;
import com.example.evaluationexercise.UI.Main.MainActivity;

public class QuestionsActivity extends BaseActivity implements QuestionsView, FragmentEventListener {

    public  static final String QUESTION1_TAG = "Question1";
    public  static final String QUESTION2_TAG = "Question2";

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    int answer1=0, answer2=0 ;
    Fragment activeFragment;
    QuestionsPresenterImp<QuestionsActivity> presenter;
    String branchName;
    String branchId;
    Question2 fragment2;
    Question1 fragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        if(savedInstanceState == null) {
            Intent intent = getIntent();
            branchName = intent.getStringExtra("BranchName");
            branchId = intent.getStringExtra("BranchId");
            setUp();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "ActiveFragment" , activeFragment);
        outState.putInt("Answer1" , answer1);
        outState.putInt("Answer2",answer2);
        outState.putString("BranchId", branchId );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        answer1 = savedInstanceState.getInt("Answer1");
        answer2 = savedInstanceState.getInt("Answer2");
        branchId = savedInstanceState.getString("BranchId") ;
        activeFragment = getSupportFragmentManager().getFragment(savedInstanceState,"ActiveFragment");
        Restore();
    }

    @Override
    public void setUp(){
        presenter  =new QuestionsPresenterImp<>();
        presenter.onAttach(this);
        SetActionBar();
        fragment = new Question1();
        setActiveFragment(fragment,QUESTION1_TAG,false);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(activeFragment instanceof Question2){
            activeFragment = getSupportFragmentManager().findFragmentByTag("Question1");
        }
    }

    @Override
    public void ReplaceFragment(){
        fragment2 = Question2.newInstance(answer1);
        setActiveFragment(fragment2,QUESTION2_TAG,true);
    }

    @Override
    public void UpdateAnswerResult(int number) {
        Log.d("Update to",""+number);
        if (activeFragment instanceof Question1 ){
            answer1  = number;
            Log.d("After Update from Question1 answer is" , "" + number);
        }
        else if (activeFragment instanceof Question2) {
            answer2 = number;
            Log.d("After Update from Question2 answer is" , "" + number);
        }
    }

    @Override
    public void EndOfQuestions(){
        presenter.SetBranchId(branchId);
        if(isNetworkConnected(this)) {
            presenter.PrepareAnswerToPost(answer1, answer2);
        }
        else{
            Toast.makeText(this, "Χρειάζεται να συνδεθείτε στο διαδίκτυο", Toast.LENGTH_LONG).show();
        }
    }

    private void setActiveFragment(Fragment fragment, String TAG, boolean addTostack){
        fm = getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        activeFragment = fragment;
        if(addTostack){
            fragmentTransaction.addToBackStack(TAG);
        }
        fragmentTransaction.replace(R.id.fragment_container, fragment, TAG);
        fragmentTransaction.commit();
    }

    private void SetActionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(branchName);
    }

    private  void Restore(){
        presenter  =new QuestionsPresenterImp<>();
        presenter.onAttach(this);
        if (activeFragment instanceof Question1) {
            setActiveFragment(activeFragment, "Question1", false);
            fragment = (Question1) activeFragment;
        }else{
            setActiveFragment(activeFragment, "Question2", false);
            fragment2 = (Question2) activeFragment;
            fragment = new Question1();
        }
    }

    @Override
    public void CloseQuestions() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void ShowGreetings(){
        Toast.makeText(this, R.string.thanks , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowError(Throwable e){
        Toast.makeText(this,"An error occurred: "+ e.toString(),Toast.LENGTH_LONG).show();
    }
}