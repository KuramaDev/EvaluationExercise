package com.example.evaluationexercise.UI.Main;

import com.example.evaluationexercise.Models.BranchInfo;
import com.example.evaluationexercise.UI.Base.BaseView;
import java.util.List;

interface MainActivityView extends BaseView {
    void InitiateList(List<BranchInfo> fetcedBranches);
}
