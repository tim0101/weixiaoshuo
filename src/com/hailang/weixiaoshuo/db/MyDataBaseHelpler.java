package com.hailang.weixiaoshuo.db;


import com.hailang.weixiaoshuo.R;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDataBaseHelpler extends SQLiteOpenHelper {
	
	private Context context;
	private static final String DATABASE_NAME="hailang_weixs.db";
	private static final int DB_VERSION=1;
	public MyDataBaseHelpler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, null, DB_VERSION);
		this.context=context;
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String[] sql_arrays = context.getResources().getStringArray(
				R.array.create_table_sql_array);
		try {
			for (String sql : sql_arrays) {
				db.execSQL(sql);
			}
		} catch (Exception ex) {
			Log.e("------AllTable-------", ex.getMessage());
		} 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists shopcar");
		onCreate(db);

	}

}
