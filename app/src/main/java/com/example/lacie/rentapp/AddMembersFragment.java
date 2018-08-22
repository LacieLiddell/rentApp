package com.example.lacie.rentapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lacie.rentapp.RoomTest.AppDatabase;
import com.example.lacie.rentapp.RoomTest.DBSingleton;
import com.example.lacie.rentapp.RoomTest.Member;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMembersFragment extends Fragment {
//    String name;
//    int rent;

    public AddMembersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_members, container, false);
        final EditText nameText = v.findViewById(R.id.edit_name_id);
        final  EditText rentText = v.findViewById(R.id.edit_rent_id);
        Button saveButton = v.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO строки из res
                String name = nameText.getText().toString();
                int rent = Integer.parseInt(rentText.getText().toString());
                if (name.isEmpty() || rentText.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Введите все данные", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Thread thread = new CustomThread(name, rent);
                    thread.start();
                    Toast.makeText(getContext(), "Участник добавлен", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private class CustomThread extends Thread {
        private String name;
        private int rent;
        CustomThread(String name, int rent){
            this.name = name;
            this.rent = rent;
        }

        @Override
        public void run() {
            super.run();
            AppDatabase db = DBSingleton.getInstance().getDatabase();
            Member member = new Member();
//            member._id = db.memberDAO().count();
            member.name = name;
            member.rent = rent;
            db.memberDAO().insert(member);
        }
    }

}
