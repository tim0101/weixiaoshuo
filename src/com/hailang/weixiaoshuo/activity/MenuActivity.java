package com.hailang.weixiaoshuo.activity;

import java.util.Stack;

import com.hailang.weixiaoshuo.R;
import com.hailang.weixiaoshuo.R.drawable;
import com.hailang.weixiaoshuo.R.id;
import com.hailang.weixiaoshuo.R.string;
import com.hailang.weixiaoshuo.util.ActivityManagerTool;
import com.hailang.weixiaoshuo.util.Tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements 
		OnClickListener{

	protected View llIndex;// 首页
	protected View llSearch;// 搜索
	protected View llUserearea;// 用户中心
	protected View llMore;// 更多

	protected ImageView igwIndex;// 首页
	protected ImageView igwSearch;// 搜索
	protected ImageView igwUserarea;// 用户中心
	protected ImageView igwMore;// 更多

	protected static final int id_Index = R.id.ll_index;
	protected static final int id_Search = R.id.ll_search;
	protected static final int id_Userarea = R.id.ll_userarea;
	protected static final int id_More = R.id.ll_more;

	protected static final int DIALOG_LOAD_DATA = 10;// 数据加载中
	protected static final int DIALOG_LOAD_DATA_FAIL = 11;// 获取数据错误
	protected static final int DIALOG_NETWORK_INAVIABLE = 101;// 网络不可用
	protected static final int DIALOG_EXIT = 0;// 退出

	protected int currentMenuId;//当前菜单Id
	protected static ActivityManagerTool amTool;// Activity管理器
	protected static ProgressDialog loadDataProgressDialog;
	protected AlertDialog.Builder loadDataFailDialog, networkInaviableDialog,
			exitDialog;
	static {
		amTool = ActivityManagerTool.getInstance();
	}
	private static Stack<Activity> menuStack = new Stack<Activity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initMemuButton();
		initCurrentMemuButton(this.currentMenuId);
	}
	public void exitApp(){
		while(!menuStack.empty()){
			Activity paramActivity=menuStack.firstElement();
			if (paramActivity != null) {
				menuStack.remove(paramActivity);
				paramActivity.finish();
			}
		}
	}
	protected void initMemuButton() {
		llIndex = findViewById(R.id.ll_index);
		llSearch = findViewById(R.id.ll_search);
		llUserearea = findViewById(R.id.ll_userarea);
		llMore = findViewById(R.id.ll_more);

		igwIndex = (ImageView) findViewById(R.id.igw_index);
		igwSearch = (ImageView) findViewById(R.id.igw_search);
		igwUserarea = (ImageView) findViewById(R.id.igw_userarea);
		igwMore = (ImageView) findViewById(R.id.igw_more);

		llIndex.setOnClickListener(this);
		llUserearea.setOnClickListener(this);
		llSearch.setOnClickListener(this);
		llMore.setOnClickListener(this);

	}
	@Override
	protected void onPause() {
		super.onPause();
	}
	protected void fullScreen() {
		//无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置全屏
/*		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == currentMenuId) {
			return;
		}
		//dufaultMemuButton(currentMenuId);
		Intent intent = new Intent();
		switch (v.getId()) {
		case id_Index:
			//igwIndex.setImageResource(R.drawable.menu_home_selected);
			intent.setClass(MenuActivity.this, IndexActivity.class);
			startActivity(intent);
			amTool.removeAllActivityExceptNewOne();
			break;
		case id_Search:
			//igwSearch.setImageResource(R.drawable.menu_search_selected);
			intent.setClass(MenuActivity.this, SearchActivity.class);
			startActivity(intent);
			amTool.removeAllActivityExceptNewOne();
			break;
		case id_Userarea:
			intent.setClass(MenuActivity.this, UserareaActivity.class);
			startActivity(intent);
			amTool.removeAllActivityExceptNewOne();
			break;
		case id_More:
			//igwMore.setImageResource(R.drawable.menu_more_selected);
			intent.setClass(MenuActivity.this, MoreActivity.class);
			startActivity(intent);
			amTool.removeAllActivityExceptNewOne();
			break;
		default:
			break;
		}
	}

	public void initCurrentMemuButton(int currentId) {
		switch (currentId) {
		case id_Index:
			this.igwIndex.setImageResource(R.drawable.menu_home_selected);
			this.llIndex.setBackgroundResource(R.drawable.menu_selected_bg);
			break;
		case id_Search:
			this.igwSearch.setImageResource(R.drawable.menu_search_selected);
			this.llSearch.setBackgroundResource(R.drawable.menu_selected_bg);
			break;
		case id_Userarea:
			this.igwUserarea.setImageResource(R.drawable.menu_shopcar_selected);
			this.llUserearea.setBackgroundResource(R.drawable.menu_selected_bg);
			break;
		case id_More:
			this.igwMore.setImageResource(R.drawable.menu_more_selected);
			this.llMore.setBackgroundResource(R.drawable.menu_selected_bg);
			break;
		}

	}
	public boolean networkIsOk() {
		return Tools.isNetworkAvailable(this);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_LOAD_DATA:
			loadDataProgressDialog = new ProgressDialog(this);
			loadDataProgressDialog.setTitle(R.string.dialog_tip);
			loadDataProgressDialog
					.setMessage(getString(R.string.dialog_loading));
			loadDataProgressDialog.show();
			return loadDataProgressDialog;
		case DIALOG_LOAD_DATA_FAIL:
			loadDataFailDialog = new AlertDialog.Builder(this);
			loadDataFailDialog.setTitle(R.string.dialog_tip);
			loadDataFailDialog.setMessage(R.string.getdata_fail);
			loadDataFailDialog.setPositiveButton(R.string.dialog_ok, null);
			loadDataFailDialog.create();
			return loadDataFailDialog.show();
		case DIALOG_NETWORK_INAVIABLE:

		case DIALOG_EXIT:
			exitDialog = new AlertDialog.Builder(this);
			exitDialog.setTitle(R.string.dialog_tip);
			exitDialog.setMessage(R.string.eixt_dialog_msg);
			exitDialog.setPositiveButton(R.string.dialog_exit,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(
								DialogInterface paramDialogInterface,
								int paramInt) {
							MenuActivity.this.exitApp();
							System.exit(0);
						}
					});
			exitDialog.setNegativeButton(R.string.dialog_cancl, null);
			exitDialog.create();
			return exitDialog.show();
		}
		return super.onCreateDialog(id);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			amTool.removeActivity(MenuActivity.this);
		}
		return super.onKeyDown(keyCode, event);
	}
	public boolean addMenuActivity(Activity activity) {
		return menuStack.add(activity);
	}
	public void initData(String contennt) throws Exception {
		dismissDialog(DIALOG_LOAD_DATA);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public void getData() throws Exception {
		showDialog(DIALOG_LOAD_DATA);
	}

	protected class JsonHandler extends Handler {
		public void handleMessage(Message msg) {
			String content = msg.getData().getString("content");
			if (content != null && !content.trim().equals("")) {
				try {
					initData(content);
				} catch (Exception es) {
					es.printStackTrace();
				}
			} else {
				requestFail();
			}
		}
	};

	public void requestFail() {
		if (!MenuActivity.this.isFinishing()) {
			if (loadDataProgressDialog.isShowing()) {
				dismissDialog(DIALOG_LOAD_DATA);
			}
			showDialog(DIALOG_LOAD_DATA_FAIL);
		}
	}
}
