package com.rms.helpmeapp.ui.offers.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder>{

    private List<Offer> offers;

    public OfferAdapter(List<Offer> offers) {
        this.offers = offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(offers.get(position).getTitle());
        holder.tvDescription.setText(offers.get(position).getDescription());
        holder.tvLocation.setText(offers.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    /**
     * View Holder class
     */
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public View view;
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvLocation;

        public ViewHolder(View view){
            super(view);
            this.view = view;
            this.tvTitle = view.findViewById(R.id.tvTitle);
            this.tvDescription = view.findViewById(R.id.tvDescription);
            this.tvLocation = view.findViewById(R.id.tvLocation);
        }
    }
}
