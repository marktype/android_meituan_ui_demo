package com.example.ui.meituan;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper{
	private static final String DB_BASENAME = "testuser.db"; //数据库名
	private static final int DB_VERSION = 1;  //版本信息
	public static final String TABLE_USER = "user"; //表名
	private static final String NAME = "name";
	private static final String _ID_KEY = "INTEGER PRIMARY KEY AUTOINCREMENT";
	private static final String _ID = "_id";
	private static final String PASSWORD = "password";
	
	public MyDataBase(Context context) {
		super(context, DB_BASENAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table "+TABLE_USER+" ("+_ID+" "+_ID_KEY+","+NAME+" varchar,"+PASSWORD+" varchar)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public void add(String name,String password){
		SQLiteDatabase db = getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put(NAME, name);
		values.put(PASSWORD, password);
		db.insert(MyDataBase.TABLE_USER, null, values);
	}
	public ArrayList<User> query(){
		ArrayList<User> userData = new ArrayList<User>();
		SQLiteDatabase db = getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_USER, null, null, null, null, null, null);
		if (cursor.getCount() > 0 && cursor!=null) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex(NAME));
				String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
			
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			userData.add(user);
			}
			
		}
		
		return userData;
	}
	public ArrayList<String> queryByString(){
		ArrayList<String> userData = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_USER, null, null, null, null, null, null);
		if (cursor.getCount() > 0 && cursor!=null) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex(NAME));
				String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
			
			String str = name+"\t"+password;
			userData.add(str);
			}
			
		}
		
		return userData;
	}
}
