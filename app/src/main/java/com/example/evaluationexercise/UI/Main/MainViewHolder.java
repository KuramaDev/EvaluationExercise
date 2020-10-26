package com.example.evaluationexercise.UI.Main;

import android.view.View;
import android.widget.TextView;
import com.example.evaluationexercise.R;
import androidx.recyclerview.widget.RecyclerView;

class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView branchName, branchArea , branchCity;
    ItemClickListener itemClickListener;

    public MainViewHolder(View itemView) {
        super(itemView);
        branchName = itemView.findViewById(R.id.branchName);
        branchArea = itemView.findViewById(R.id.branchArea);
        branchCity = itemView.findViewById(R.id.branchCity);
    }

    @Override
    public void onClick(View view){
        itemClickListener.OnBranchInfoClicked(getAdapterPosition());
    }

    public void BindListener(ItemClickListener listener){
        this.itemClickListener = listener;
        itemView.setOnClickListener(this);

    }
}
