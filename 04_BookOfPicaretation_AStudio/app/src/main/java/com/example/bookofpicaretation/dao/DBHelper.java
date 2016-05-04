package com.example.bookofpicaretation.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "picaretation.db";
	private static final int DATABASE_VERSION = 2;
	
	public static final String TABLE_COLLABORATOR = "collaborator";
	public static final String TABLE_ISSUE = "issue";
	public static final String TABLE_GROUP = "groups";
	public static final String TABLE_GROUP_COLLABORATOR = "group_collaborator";
	
	public static final String SQL_CREATE_TABLE_COLLABORATOR = "CREATE TABLE " + TABLE_COLLABORATOR + "("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT NOT NULL, "
				+ "phone TEXT, "
				+ "email TEXT);";
	
	public static final String SQL_CREATE_TABLE_ISSUE = "CREATE TABLE " + TABLE_ISSUE + "("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT NOT NULL, "
				+ "description TEXT, "
				+ "value REAL NOT NULL, "
				+ "type INTEGER NOT NULL, "
				+ "closed INTEGER NOT NULL, "
				+ "id_collaborator INTEGER NOT NULL);";
	
	public static final String SQL_CREATE_TABLE_GROUP = "CREATE TABLE " + TABLE_GROUP + "("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT NOT NULL);";
	
	public static final String SQL_CREATE_TABLE_GROUP_COLLABORATOR = "CREATE TABLE " + TABLE_GROUP_COLLABORATOR + "("
				+ "id_group INTEGER NOT NULL, "
				+ "id_collaborator INTEGER NOT NULL);";
	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_TABLE_COLLABORATOR);
		db.execSQL(SQL_CREATE_TABLE_ISSUE);
		db.execSQL(SQL_CREATE_TABLE_GROUP);
		db.execSQL(SQL_CREATE_TABLE_GROUP_COLLABORATOR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w("DBHelper", "atualizando o bd da versao " + oldVersion + " para a versao " + newVersion);
		//realizar aqui os passos para migracao dos dados
		
		//neste caso, apaga as tabelas existentes
		db.execSQL("DROP IF EXISTS " + TABLE_GROUP_COLLABORATOR);
		db.execSQL("DROP IF EXISTS " + TABLE_GROUP);
		db.execSQL("DROP IF EXISTS " + TABLE_ISSUE);
		db.execSQL("DROP IF EXISTS " + TABLE_COLLABORATOR);
		
		//e manda criar novamente
		onCreate(db);
	}
}
