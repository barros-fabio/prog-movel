package com.example.fabio.avaliacao01parte02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fabio on 5/1/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "questao7";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE Pessoa(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, sexo TEXT NOT NULL, idade INTEGER NOT NULL); ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS Pessoa");
        onCreate(db);
    }


}
