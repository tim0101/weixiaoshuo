package com.hailang.weixiaoshuo.activity;

import com.hailang.weixiaoshuo.R;
import com.hailang.weixiaoshuo.model.IBackTitle;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class BackTitelActivity extends MenuActivity implements IBackTitle{

	public BackTitelActivity(){
		this.amTool.addActivity(this);
	}
	protected void onCreate(Bundle savedInstanceState) {
		initBackButton();
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public void initBackButton() {
		Button btnBack = (Button) findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				handleBackButton();
			}
		});
	}

	@Override
	public void handleBackButton() {
		this.amTool.removeActivity(this);
	}

	@Override
	public void initTextName(String strTitleName) {
		TextView txtTitleName = (TextView) findViewById(R.id.txt_title_name);
		txtTitleName.setText(strTitleName);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			this.amTool.removeActivity(this);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
