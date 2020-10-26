package com.example.evaluationexercise.UI.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.evaluationexercise.Models.BranchInfo;
import com.example.evaluationexercise.R;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<BranchInfo> branches;
    private ItemClickListener listener;

    public MainAdapter(List<BranchInfo> branches, ItemClickListener listener){
        this.branches=branches;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.card_view_branch, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        BranchInfo branch = branches.get(position);
        holder.branchName.setText(branch.getName());
        holder.branchCity.setText(branch.getCity());
        holder.branchArea.setText(branch.getArea());
        holder.BindListener(listener);
    }

    @Override
    public int getItemCount() {
        return branches.size();
    }

}
