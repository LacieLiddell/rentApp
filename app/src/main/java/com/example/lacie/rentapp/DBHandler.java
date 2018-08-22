package com.example.lacie.rentapp;

import android.os.Handler;
import android.os.HandlerThread;

import com.example.lacie.rentapp.RoomTest.Member;

import java.util.ArrayList;

public class DBHandler extends HandlerThread{
    private Handler workerHandler;
    private Handler mResponseHandler;
    private static final String TAG = DBHandler.class.getSimpleName();
    private Handler.Callback mCallback;
    private ArrayList <Member> memberArrayList;

    public DBHandler(Handler responseHandler, Handler.Callback callback) {
        super(TAG);
        mResponseHandler = responseHandler;
        mCallback = callback;
    }

    public interface Callback {
        public void onMembersDownload();
    }



}
