package com.example.lacie.rentapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {
    private String [] name, rent, number;
    private OnItemClickListener listener;


    public MembersAdapter(String[] members,String [] rent, String [] number, OnItemClickListener listener){
        this.name = members;
        this.rent = rent;
        this.number = number;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onClick(CardView card, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_count, parent, false);

        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = (CardView) holder.cardView;
        TextView numberView = cardView.findViewById(R.id.member_number);
        TextView nameView = cardView.findViewById(R.id.member_name);
        TextView partView = cardView.findViewById(R.id.member_part);
        numberView.setText(number[position]);
        nameView.setText(name[position]);
        partView.setText(rent[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("+++++++++++++++++", "трогнуто " + position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView card) {
            super(card);
            cardView = card;
        }
    }
}
