package com.hailang.weixiaoshuo.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import com.hailang.weixiaoshuo.R;

public class UserareaActivity extends MenuActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		fullScreen();
		setContentView(R.layout.userarea);
		currentMenuId=id_Userarea;
		super.onCreate(savedInstanceState);
		this.addMenuActivity(this);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			showDialog(DIALOG_EXIT);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
