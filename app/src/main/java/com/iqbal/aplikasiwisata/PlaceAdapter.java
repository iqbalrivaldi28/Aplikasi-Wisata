package com.aditya.natureexploresampleui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.natureexploresampleui.model.Places;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private ArrayList<Places> listPlaces = new ArrayList<>();


    void setData(ArrayList<Places> listPlace) {
        listPlaces.clear();
        listPlaces.addAll(listPlace);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_camp, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Places places = listPlaces.get(position);
        Glide.with(holder.itemView.getContext())
                .load(places.getImage())
                .into(holder.placeImage);
        holder.tvNama.setText(places.getNama());
        holder.tvLocation.setText(places.getJarak());
    }

    @Override
    public int getItemCount() {
        return listPlaces.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama;
        private TextView tvLocation;
        private ImageView placeImage;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_place);
            tvLocation = itemView.findViewById(R.id.location);
            placeImage = itemView.findViewById(R.id.img_place);
        }
    }
}
