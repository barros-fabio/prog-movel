package com.example.bookofpicaretation.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.bookofpicaretation.entity.Collaborator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CollaboratorDAO {
	
	private DBHelper dbHelper;
	private SQLiteDatabase mDatabase;
	
	public CollaboratorDAO(Context context) {
		dbHelper = new DBHelper(context);
		try {
			open(); 
		}catch(Exception e) {
			Log.e("CollaboratorDAO", "Exception while connecting the DB.");
			e.printStackTrace();
		}
	}
	
	public void open() throws Exception {
		mDatabase = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}

	public void save(Collaborator c) {
		ContentValues values = new ContentValues();
		
		values.put("name", c.getName());
		values.put("phone", c.getPhone());
		values.put("email", c.getEmail());
		
		long generatedId = mDatabase.insert(DBHelper.TABLE_COLLABORATOR, null, values);
		c.setId(generatedId);
	}

	public List<Collaborator> getAll() {
		List<Collaborator> ret = new ArrayList<Collaborator>();
		
		Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + DBHelper.TABLE_COLLABORATOR, null);
		cursor.moveToFirst();
		
		while(! cursor.isAfterLast()) {
			Collaborator c = cursorToCollaborator(cursor);
			ret.add(c);
			cursor.moveToNext();
		}
		cursor.close();
		
		return ret;
	}
	
	private Collaborator cursorToCollaborator(Cursor cursor) {
		Collaborator c = new Collaborator();
		
		c.setId( cursor.getLong(0) );
		c.setName( cursor.getString(1) );
		c.setPhone( cursor.getString(2) );
		c.setEmail( cursor.getString(3) );
		
		return c;
	}

	public void delete(Collaborator c) {
		mDatabase.delete(DBHelper.TABLE_COLLABORATOR, "_id = " + c.getId(), null);		
	}

	public Collaborator getById(long editId) {
		Collaborator c = null;
		Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + DBHelper.TABLE_COLLABORATOR + " WHERE _id="+editId, null);
		cursor.moveToFirst();		
		if(! cursor.isAfterLast()) {
			c = cursorToCollaborator(cursor);
		}
		cursor.close();
		
		return c;
	}

	public void update(Collaborator c) {
		ContentValues values = new ContentValues();
		
		values.put("name", c.getName());
		values.put("phone", c.getPhone());
		values.put("email", c.getEmail());
		
		mDatabase.update(DBHelper.TABLE_COLLABORATOR, values, "_id = " + c.getId(), null);
	}
}