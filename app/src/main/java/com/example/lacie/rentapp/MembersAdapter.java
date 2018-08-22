package com.example.lacie.rentapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lacie.rentapp.RoomTest.Member;

import java.util.List;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {
    private String [] name;
    private long[] rent;
    int []number;
    OnItemClickListener listener;


    public MembersAdapter(String[] members, long[] rent, int[] number, OnItemClickListener listener){
        this.name = members;
        this.rent = rent;
        this.number = number;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(CardView card, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_card, parent, false);
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        TextView numberView = cardView.findViewById(R.id.member_number);
        TextView nameView = cardView.findViewById(R.id.member_name);
        TextView partView = cardView.findViewById(R.id.member_part);
//        numberView.setText(number[position]);
        nameView.setText(name[position]);
//        partView.setText((int) rent[position]);
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
