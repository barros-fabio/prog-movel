package com.example.bookofpicaretation.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.bookofpicaretation.entity.Collaborator;
import com.example.bookofpicaretation.entity.Issue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class IssueDAO {
	private DBHelper dbHelper;
	private SQLiteDatabase mDatabase;
	
	public IssueDAO(Context context) {
		dbHelper = new DBHelper(context);
		try {
			open(); 
		}catch(Exception e) {
			Log.e("IssueDAO", "Exception while connecting the DB.");
			e.printStackTrace();
		}
	}
	
	public void open() throws Exception {
		mDatabase = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}

	public List<Issue> getBy(Collaborator c) {
		ArrayList<Issue> ret = new ArrayList<Issue>();
		
		Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + DBHelper.TABLE_ISSUE + " WHERE id_collaborator= ? and closed = 0", 
																	new String [] { String.valueOf(c.getId()) });
		cursor.moveToFirst();
		while(! cursor.isAfterLast()) {
			Issue i = cursorToIssue(cursor, c);
			ret.add(i);
			cursor.moveToNext();
		}
		cursor.close();		
		
		return ret;
	}

	private Issue cursorToIssue(Cursor cursor, Collaborator c) {
		Issue i = new Issue();
		
		i.setId( cursor.getLong(0) );
		i.setName( cursor.getString(1) );
		i.setDescription( cursor.getString(2) );
		i.setValue( cursor.getDouble(3) );
		i.setType( cursor.getLong(4) );
		i.setClosed( cursor.getLong(5) == 1 ? true : false );
		i.setCollaborator(c);
		
		return i;
	}

	public String calculateSummary(List<Issue> issues) {
		if (issues.isEmpty())
			return "no issue";
		
		double toPay = 0, toReceive = 0;
		for (Issue i : issues) {
			if(i.getType() == Issue.TOPAY)
				toPay += i.getValue();
			else if(i.getType() == Issue.TORECEIVE)
				toReceive += i.getValue();
		}
		
		if(toPay == toReceive)
			return "no debts, zero";
		
		DecimalFormat df = new DecimalFormat("#.00"); 
		if(toPay > toReceive) {
			return "Negative. You should pay " + df.format(toPay - toReceive);
		}
		else
			return "Positive. You should receive " + df.format(toReceive - toPay);
	}

	public void save(Issue i) {
		ContentValues values = new ContentValues();
		
		values.put("name", i.getName());
		values.put("description", i.getDescription());
		values.put("value", i.getValue());
		values.put("type", i.getType());
		values.put("closed", i.isClosed() ? 1 : 0);
		values.put("id_collaborator", i.getCollaborator().getId());
		
		long generatedId = mDatabase.insert(DBHelper.TABLE_ISSUE, null, values);
		i.setId(generatedId);
	}
}
