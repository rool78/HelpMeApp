package com.rms.helpmeapp.ui.offers.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rms.helpmeapp.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder>{

    private List<String> titlesTest;

    public OfferAdapter(List<String> products){
        this.titlesTest = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        holder.tvData.setText(titlesTest.get(position));
    }

    @Override
    public int getItemCount() {
        return titlesTest.size();
    }

    /**
     * View Holder class
     */
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public View view;
        public TextView tvData;

        public ViewHolder(View view){
            super(view);
            this.view = view;
            this.tvData = view.findViewById(R.id.tvTitle);

        }
    }
}
