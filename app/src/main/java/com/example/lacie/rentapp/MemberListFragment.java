package com.example.lacie.rentapp;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lacie.rentapp.RoomTest.AppDatabase;
import com.example.lacie.rentapp.RoomTest.DBSingleton;
import com.example.lacie.rentapp.RoomTest.Member;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberListFragment extends Fragment implements MembersAdapter.OnItemClickListener{
    private String[] name;
    private  int [] id;
    private long [] part;
    MembersAdapter adapter;

    public MemberListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) getLayoutInflater()
                .inflate(R.layout.fragment_member_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = DBSingleton.getInstance().getDatabase();
                List<Member> memberArrayList = db.memberDAO().getAll();
                parse(memberArrayList);
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MembersAdapter(name, part, id, MemberListFragment.this);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
        return recyclerView;
    }

//    private void startThread(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                handler = new Handler(handlerCallback);
//                Looper.loop();
//            }
//        }).start();
//    }


    private void parse (List <Member> list){
        int i = 0;
        name = new String[list.size()];
        id = new int[list.size()];
        part = new long[list.size()];
        for (Member member:list) {
            name[i] = member.name;
            id[i] = member._id;
            part[i] = member.rent;
            Log.d("++++++++++++++++", name[i]);
        }
    }



    @Override
    public void onItemClick(CardView card, int position) {
            Log.d("=============", "тронуто, фрагмент");
    }

//    private final Handler.Callback handlerCallback = new Handler.Callback() {
//
//        private Handler uiHandler = new Handler(Looper.getMainLooper());
//
//        @Override
//        public boolean handleMessage(Message msg) {
//            //TODO подумать про msg.what и нельзя ли всё это безобразие упростить
//            AppDatabase db = DBSingleton.getInstance().getDatabase();
//            final ArrayList <Member> memberArrayList = db.memberDAO().getAll();//(ArrayList<Member>) msg.obj;
//            switch (msg.what){
//                case MEMBER_LIST_IS_EMPTY:
//                    name = null;
//                    id = null;
//                    part = null;
//                    break;
//                case MEMBER_LIST_NOT_EMPTY:
//                    int i = 0;
//                    name = new String[memberArrayList.size()];
//                    id = new int[memberArrayList.size()];
//                    part = new long[memberArrayList.size()];
//                    for (Member member:memberArrayList) {
//                        name[i] = member.name;
//                        id[i] = member._id;
//                        part[i] = member.rent;
//                    }
//                    break;
//                    default:
//                        return false;
//            }
//            uiHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    adapter = new MembersAdapter(name, part, id,
//                            MemberListFragment.this);
//                }
//            });
//            return true;
//        }
//    };



}
