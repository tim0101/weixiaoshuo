package com.hailang.weixiaoshuo.db;

import java.util.ArrayList;
import java.util.List;

import com.hailang.weixiaoshuo.bean.ContentBean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;

public class WxsContentDBAdapter {
	private final String TABLE_NAME = "wsx_content";
	private SQLiteDatabase db;
	private static Context context;
	private static MyDataBaseHelpler myDataHepler;
	private static WxsContentDBAdapter myDBAdapter;

	//列名
	private static final String CONTENT_ID="content_id";
	private static final String CONTENT="content";
	private static final String USER_ID="user_id";
	private static final String USER_NAME="user_name";
	private static final String CREATE_DATE="create_date";
	private static final String TRANSMIT_NUM="transmit_num";
	private static final String FAVORITE_NUM="favorite_num";
	private static final String COMMENT_NUM="comment_num";
	
	public WxsContentDBAdapter(Context context) {
		this.context = context;
		myDataHepler = new MyDataBaseHelpler(this.context, null, null, 0);
	}

	public static WxsContentDBAdapter getInstance(Context context) {
		// this.context = context;
		// myDataHepler = new MyDataBaseHelpler(context, null, null, 0);
		if (myDBAdapter == null) {
			myDBAdapter = new WxsContentDBAdapter(context);
		}
		myDBAdapter.open();
		return myDBAdapter;
	}

	private void open() throws SQLiteException {
		try {
			db = myDataHepler.getWritableDatabase();
		} catch (SQLiteException ex) {
			db = myDataHepler.getReadableDatabase();
		}
	}

	public void closeDB() {
		if ((this.db != null) && (this.db.isOpen()))
			this.db.close();
	}

	public boolean addToDB(ContentBean contentBean) {
		ContentValues contentValue = new ContentValues();
		contentValue.put(WxsContentDBAdapter.CONTENT_ID, contentBean.getContentId());
		contentValue.put(WxsContentDBAdapter.CONTENT,contentBean.getStrContent());
		contentValue.put(WxsContentDBAdapter.USER_ID,contentBean.getUserId());
		contentValue.put(WxsContentDBAdapter.USER_NAME,contentBean.getStrUserName());
		contentValue.put(WxsContentDBAdapter.CREATE_DATE,contentBean.getStrCreateDate());
		contentValue.put(WxsContentDBAdapter.TRANSMIT_NUM,contentBean.getStrTransmitNum());
		contentValue.put(WxsContentDBAdapter.FAVORITE_NUM,contentBean.getStrFavoriteNum());
		contentValue.put(WxsContentDBAdapter.COMMENT_NUM,contentBean.getStrCommentNum());
		
		long rs;
		try {
			db.beginTransaction();// 开始事务
			rs = db.insert(TABLE_NAME, null, contentValue);
			db.setTransactionSuccessful();// 提交事务
		} catch (SQLException ex) {
			throw ex;
		} finally {
			db.endTransaction();// 结束事务
		}
		closeDB();
		return rs > 0;
	}
/*
	public boolean updateShopcar(List<ContentBean> beanLIst) {
		for (ContentBean contentBean : beanLIst) {
			ContentValues contentValue = new ContentValues();
			contentValue.put("adult_num", contentBean.getStrAdultNum());
			contentValue.put("child_num", contentBean.getStrChildNum());
			contentValue.put("total_price", contentBean.getStrTotalPrice());
			long rs;
			try {
				db.beginTransaction();// 开始事务
				rs = db.update(TABLE_NAME, contentValue,
						"_id=" + contentBean.getId(), null);
				db.setTransactionSuccessful();// 提交事务
			} catch (SQLException ex) {
				throw ex;
			} finally {
				db.endTransaction();// 结束事务
			}
		}
		closeDB();
		return 1 > 0;
	}
*/
	public ContentBean getContentBeanById(int Id) {
		ContentBean contentBean = new ContentBean();
		;
		Cursor c = db.query(TABLE_NAME, null, "_id=" + Id, null, null, null,
				null);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

		}
		c.close();
		closeDB();
		return contentBean;
	}

	public List<ContentBean> getContentList() {
		List<ContentBean> contentBeanList = new ArrayList<ContentBean>();
		ContentBean contentBean = null;
		Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			contentBean = new ContentBean();
			contentBean.setContentId(c.getLong(c.getColumnIndex(WxsContentDBAdapter.CONTENT_ID)));
			contentBean.setStrContent(c.getString(c.getColumnIndex(WxsContentDBAdapter.CONTENT)));
			contentBean.setUserId(c.getLong(c.getColumnIndex(WxsContentDBAdapter.USER_ID)));
			contentBean.setStrUserName(c.getString(c.getColumnIndex(WxsContentDBAdapter.USER_NAME)));
			contentBean.setStrCreateDate(c.getString(c.getColumnIndex(WxsContentDBAdapter.CREATE_DATE)));
			contentBean.setStrTransmitNum(c.getString(c.getColumnIndex(WxsContentDBAdapter.TRANSMIT_NUM)));
			contentBean.setStrFavoriteNum(c.getString(c.getColumnIndex(WxsContentDBAdapter.FAVORITE_NUM)));
			contentBean.setStrCommentNum(c.getString(c.getColumnIndex(WxsContentDBAdapter.COMMENT_NUM)));

			contentBeanList.add(contentBean);
		}
		c.close();
		closeDB();
		return contentBeanList;
	}
	public boolean deleteRecord(int id) {

		long rs;
		try {
			db.beginTransaction();// 开始事务
			rs = db.delete(TABLE_NAME, "_id=" + id, null);
			db.setTransactionSuccessful();// 提交事务
		} catch (SQLException ex) {
			throw ex;
		} finally {
			db.endTransaction();// 结束事务
		}
		closeDB();
		return rs > 0;
	}

	public boolean clearDB(String strTuanNum) {
		long rs;
		try {
			db.beginTransaction();// 开始事务
			rs = db.delete(TABLE_NAME, "1=1", null);
			db.setTransactionSuccessful();// 提交事务
		} catch (SQLException ex) {
			throw ex;
		} finally {
			db.endTransaction();// 结束事务
		}
		closeDB();
		return rs > 0;
	}
}
