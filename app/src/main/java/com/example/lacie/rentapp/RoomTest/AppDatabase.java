package com.example.lacie.rentapp.RoomTest;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Member.class}, version = 1 )
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemberDAO memberDAO();
}
