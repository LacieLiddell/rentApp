package com.example.lacie.rentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountFragment extends Fragment implements MembersAdapter.OnItemClickListener{
    private String[] name, number, part;

    public CountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) getLayoutInflater()
                .inflate(R.layout.fragment_count, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //TODO adapter and data from sharedPreferences
        name = new String[]{"name1", "name2"};
        number = new String[]{"1", "2"};
        part = new String [] {"0", "0"};
        MembersAdapter adapter = new MembersAdapter(name, part, number,
                (MembersAdapter.OnItemClickListener) this);
        return recyclerView;
    }

    @Override
    public void onClick(CardView card, int position) {

    }
}
