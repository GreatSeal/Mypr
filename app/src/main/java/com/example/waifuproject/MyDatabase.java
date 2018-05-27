package com.example.waifuproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "dbwaifu.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ID="ID";
    private static final String JAPAN ="Japan";
    private static final String RUSSIAN ="Russian";
    private static final String POSES_TABLE="dbwaifu";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<Poses> getPoses(){
        SQLiteDatabase db=getReadableDatabase();
        String[] columns={MyDatabase.ID,MyDatabase.JAPAN,MyDatabase.RUSSIAN};
//        String[] selectionArgs={categoryId+"",subjectId+"",yearId+""};
        Cursor cursor=db.query(MyDatabase.POSES_TABLE, columns, null, null, null, null, null);
//        Cursor cursor=db.query(MyDatabase.TABLE_NAME, columns, null,null, null, null, null);
        ArrayList<Poses> questionsArrayList=new ArrayList<>();

        while(cursor.moveToNext()){
            Poses questions=new Poses();
            questions.id=cursor.getInt(cursor.getColumnIndex(MyDatabase.ID));
            questions.Japan=cursor.getString(cursor.getColumnIndex(MyDatabase.JAPAN));
            questions.Russian=cursor.getString(cursor.getColumnIndex(MyDatabase.RUSSIAN));
            questionsArrayList.add(questions);
        }
        return questionsArrayList;
    }



}