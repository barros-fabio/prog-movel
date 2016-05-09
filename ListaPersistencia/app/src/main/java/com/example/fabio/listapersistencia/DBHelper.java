package com.example.fabio.listapersistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fabio on 5/4/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lista";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE Local(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, latitude TEXT NOT NULL, longitude TEXT NOT NULL); ";
        db.execSQL(sql);
        sql = "CREATE TABLE Medicao(_id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT NOT NULL, hora TEXT NOT NULL, temperatura REAL NOT NULL, umidade REAL NOT NULL, pressao REAL NOT NULL, localidade INTEGER NOT NULL, FOREIGN KEY (localidade) REFERENCES Local(_id));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS Local");
        db.execSQL("DROP TABLE IF EXISTS Medicao");
        onCreate(db);
    }


}