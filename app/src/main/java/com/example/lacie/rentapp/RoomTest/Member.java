package com.example.lacie.rentapp.RoomTest;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Member {
    @PrimaryKey
    public int _id;

    public String name;

    public long rent;
}
