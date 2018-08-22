package com.example.lacie.rentapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFABFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    public EditFABFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_fab, container, false);
        FloatingActionButton fab = view.findViewById(R.id.addFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("+++++++++++++++", "трогнут addFAB");
//                replaceFragment(R.id.container, new AddMembersFragment());
//                fragmentManager =
//
//                transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.container, new AddMembersFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });
//        replaceFragment(R.id.list_container, new MemberListFragment());
        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.add_list_container, new AddMembersFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        return view;
    }

//    void replaceFragment(int container, Fragment fragment){
//        fragmentManager = getChildFragmentManager();
//        transaction = fragmentManager.beginTransaction();
//        transaction.replace(container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }

}
