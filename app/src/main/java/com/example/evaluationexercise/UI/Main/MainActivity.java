package com.example.evaluationexercise.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.evaluationexercise.Models.BranchInfo;
import com.example.evaluationexercise.R;
import com.example.evaluationexercise.UI.Base.BaseActivity;
import com.example.evaluationexercise.UI.Questions.QuestionsActivity;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity implements MainActivityView,ItemClickListener, View.OnClickListener {

    RecyclerView rc;
    MainPresenterImp<MainActivity> presenter;
    MainAdapter adapter;
    List<BranchInfo> branches;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc = findViewById(R.id.listOfBranches);
        refresh = findViewById(R.id.refresh);
        branches =new ArrayList<>();
        presenter = new MainPresenterImp<>();
        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void setUp(){
        presenter.onAttach(MainActivity.this);
        refresh.setOnClickListener(this);
        PrepareData();
    }

    @Override
    public void InitiateList(List<BranchInfo> fetchedBranches){
        branches.addAll(fetchedBranches);
        adapter= new MainAdapter(branches, this);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnBranchInfoClicked(int position) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        String branchId = branches.get(position).getId();
        intent.putExtra("BranchId", branchId);
        intent.putExtra("BranchName",branches.get(position).getName());
        startActivity(intent);
    }

    private void PrepareData(){
        if(isNetworkConnected(this)) {
            ShowLoading();
            presenter.FetchBranches();
            refresh.setVisibility(View.GONE);
        }else{
            Toast.makeText(this,"Χρειάζεται να συνδεθείτε στο διαδίκτυο", Toast.LENGTH_SHORT).show();
            refresh.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        PrepareData();
    }

}