package com.example.lacie.rentapp.RoomTest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MemberDAO {
    @Query("Select * from member")
    List<Member> getAll();

    @Query("Select * from member where _id = :id")
    Member getById(int id);

    @Query("Select count(*) from member")
    int count();

    @Insert
    void insert(Member member);

    @Delete
    void delete(Member member);

    @Update
    void update(Member member);
}
