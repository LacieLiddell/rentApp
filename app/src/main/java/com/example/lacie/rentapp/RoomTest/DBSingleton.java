package com.example.lacie.rentapp.RoomTest;

import android.app.Application;
import android.arch.persistence.room.Room;

public class DBSingleton extends Application {
    public static DBSingleton instance;
    private AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "member").build();
    }

    public static DBSingleton getInstance(){
        return instance;
    }

    public AppDatabase getDatabase(){
        return database;
    }
}
